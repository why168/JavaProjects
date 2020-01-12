import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Edwin.Wu edwin.wu05@gmail.com
 * @version 2019-01-08 20:08
 * @since JDK1.8
 */
class Main {
    public static void main(String[] args) {
        //获取当前类所在的包
		/*File fileB = new File(WriteFileFromQueue.class.getResource("").getPath());
		System.out.println("fileB path: " + fileB); */
        //获取当前类所在的工程名
//		System.out.println(System.getProperty("user.dir"));


        FileWriter fw = null;
        BufferedWriter bufw = null;
        File file = new File(System.getProperty("user.dir") + File.separator + "upload" + File.separator + "liam.txt");
        try {
            if (!file.exists()) {
//                file.mkdirs();
                boolean newFile = file.createNewFile();
                System.out.println("newFile = " + newFile);
            }
            fw = new FileWriter(file, true);
            bufw = new BufferedWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();


        for (int i = 0; i < 10; i++) {
            new Thread(new SaveDataToQueue(queue, "写入数据为：  " + i)).start();
        }


        new Thread(new PutDataToFile(queue, bufw)).start();


        try {
            copyFile(file.getAbsolutePath(), file.getAbsolutePath() + "1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class PutDataToFile implements Runnable {
        private ConcurrentLinkedQueue<String> queue;
        private BufferedWriter buff;

        public PutDataToFile(ConcurrentLinkedQueue<String> queue, BufferedWriter buff) {
            super();
            this.queue = queue;
            this.buff = buff;
        }


        @Override
        public void run() {
            while (true) {
                if (!queue.isEmpty()) {
                    try {
                        buff.write(queue.poll());
                        buff.newLine();
                        buff.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }


    public static class SaveDataToQueue implements Runnable {
        private ConcurrentLinkedQueue<String> queue;
        private String data;

        public SaveDataToQueue(ConcurrentLinkedQueue<String> queue, String data) {
            this.queue = queue;
            this.data = data;
        }

        @Override
        public void run() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:hh:ss sss");
            data = sdf.format(new Date()) + ":" + data;
            System.out.println(data);
            queue.add(data);
        }

    }

    public static void copyFile(String srcFilePath, String destFilePath) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        FileLock flout = null;
        FileChannel fcIn = null;
        FileChannel fcOut = null;

        try {
            // 获取源文件和目标文件的输入输出流
            in = new FileInputStream(srcFilePath);
            out = new FileOutputStream(destFilePath, true);
            // 获取输入输出通道
            fcIn = in.getChannel();
            fcOut = out.getChannel();
            while (true) {
                try {
                    flout = fcOut.lock();
                    break;
                } catch (OverlappingFileLockException e) {
                    Thread.sleep(1 * 10);
                }
            }

            ByteBuffer buffer = ByteBuffer.allocate(4096);
            while (true) {
                // clear方法重设缓冲区，使它可以接受读入的数据
                buffer.clear();
                // 从输入通道中将数据读到缓冲区
                int r = fcIn.read(buffer);
                if (r == -1) {
                    break;
                }
                // flip方法让缓冲区可以将新读入的数据写入另一个通道
                buffer.flip();
                fcOut.write(buffer);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (flout != null) {
                flout.release();
            }
            if (in != null && out != null) {
                try {
                    in.close();
                    out.close();
                    System.out.println("关闭");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
