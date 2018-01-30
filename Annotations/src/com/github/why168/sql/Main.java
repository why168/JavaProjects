package com.github.why168.sql;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        try {
            Filter f1 = new Filter();
            f1.setId(10);
            f1.setCity("北京,四川");
            String sql1 = query(f1);
            System.out.println(sql1);

            Filter f2 = new Filter();
            f2.setUserName("Edwin");
            f2.setAge(21);
            f2.setEmail("edwin@qq.com");
            String sql2 = query(f2);
            System.out.println(sql2);


            Filter f3 = new Filter();
            f3.setEmail("zh@126.com,wu@163.com");
            String sql3 = query(f3);
            System.out.println(sql3);


            Filter2 filter2 = new Filter2();
            filter2.setLeader("Edwin");
            filter2.setName("车神部门");
            String sql = query(filter2);
            System.out.println(sql);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static String query(Object object) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();

        Class objectClass = object.getClass();

        boolean exists = objectClass.isAnnotationPresent(Table.class);
        if (!exists)
            return "";

        Table t = (Table) objectClass.getAnnotation(Table.class);
        String tableName = t.value();

        sb.append("select * from ")
                .append(tableName)
                .append(" where 1=1");

        Field[] fArray = objectClass.getDeclaredFields();

        for (Field field : fArray) {
            exists = field.isAnnotationPresent(Column.class);
            if (!exists) {
                continue;
            }

            field.setAccessible(true);

            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();

            Object fieldValue;
            fieldValue = field.get(object);
//            System.out.print("fieldValue == " + fieldValue);
//            System.out.println("，columnName = " + columnName);


            if (fieldValue == null)
                continue;

            if (fieldValue instanceof Integer && (Integer) fieldValue == 0)
                continue;

            sb.append(" and ").append(columnName);

            if (fieldValue instanceof String) {
                if (((String) fieldValue).contains(",")) {
                    String[] values = ((String) fieldValue).split(",");
                    sb.append(" in（");
                    for (String vales : values) {
                        sb.append("'").append(vales).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(")");
                } else {
                    sb.append("=").append("'").append(fieldValue).append("'");
                }
            } else if (fieldValue instanceof Integer) {
                sb.append("=").append(fieldValue);
            }
        }
        return sb.toString();
    }
}
