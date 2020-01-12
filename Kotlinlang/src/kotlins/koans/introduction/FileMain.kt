package kotlins.koans.introduction

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

/**
 *
 *
 * @author  Edwin.Wu edwin.wu05@gmail.com
 * @version  2019-01-08 20:47
 * @since  JDK1.8
 */
object FileMain {
    private const val CORE_POOL_SIZE: Int = 1
    private const val MAXIMUM_POOL_SIZE: Int = 1
    private const val KEEP_ALIVE_SECONDS: Long = 30
    private val sPoolWorkQueue = LinkedBlockingQueue<Runnable>()

    private val sThreadFactory = object : ThreadFactory {
        private val mCount = AtomicInteger(1)

        override fun newThread(r: Runnable): Thread {
            return Thread(r, "TrackTask #" + mCount.getAndIncrement())
        }
    }

    private val threadPoolExecutors: ThreadPoolExecutor by lazy {
        ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_SECONDS, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory)
    }

    init {
        threadPoolExecutors.allowCoreThreadTimeOut(true)


    }

    private val index = AtomicInteger(0)

    val file = File(System.getProperty("user.dir") + File.separator + "upload" + File.separator + "liam.txt")
    val fw = FileWriter(file, true)
    val buff = BufferedWriter(fw)


    @JvmStatic
    fun main(args: Array<String>) {
//        val newCachedThreadPool = Executors.newCachedThreadPool()
//
//        for (index in 0..100) {
//            newCachedThreadPool.execute(run())
//            newCachedThreadPool.execute(run())
//            newCachedThreadPool.execute(run())
//            newCachedThreadPool.execute(run())
//            newCachedThreadPool.execute(run())
//        }

        for (index in 0..100) {
            threadPoolExecutors.execute(run())
            threadPoolExecutors.execute(run())
            threadPoolExecutors.execute(run())
            threadPoolExecutors.execute(run())
            threadPoolExecutors.execute(run())
        }
    }

    private class run : Runnable {
        override fun run() {
            buff.write("index = ${FileMain.index.getAndIncrement()} time = " + System.currentTimeMillis())
            buff.newLine()
            buff.flush()
        }
    }


}