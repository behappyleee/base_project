package com.book.cleancode.chapter_9;

public class SRP_Class {

    // 중요 !!!!!!!
    // 이상적인 시스템이라면 새 기능을 추가할 시 시스템을 확장할 뿐 기존 코드는 변경하지 않는다.
    // 결합도가 낮다는 말은 각 시스템 요소가 다른 요소로부터 그리고 변경으로부터 잘 격리되어 있다는 뜻이다.

}

// Sql 클새르를 Sql ㅋ클래스에서 파생하는 클래스로 만들었다.
// valueList 와 같은 비공개 메서드는 해당하는 파생 클래스로 옮겼다
// 공개 인터페이스를 전부 SQL 클래스에서 파생하는 클래스로 만들고, 비공개 메서드는 해당 클래스로 옮기고,
// 공통된 인터페이스는 따로 클래스로 뺐다.
// 이렇게 하면 update문 추가 시에 기존의 클래스를 건드릴 이유가 없어진다.

// 아래 Sql 클래스를 고쳐보았다.
//abstract public class Sql {
//    public Sql(String table, Column[] columns)
//    abstract public String generate();
//}
//public class CreateSql extends Sql {
//    public CreateSql(String table, Column[] columns)
//    @Override public String generate()
//}
//
//public class SelectSql extends Sql {
//    public SelectSql(String table, Column[] columns)
//    @Override public String generate()
//}
//
//public class InsertSql extends Sql {
//    public InsertSql(String table, Column[] columns, Object[] fields)
//    @Override public String generate()
//    private String valuesList(Object[] fields, final Column[] columns)
//}
//
//public class SelectWithCriteriaSql extends Sql {
//    public SelectWithCriteriaSql(
//            String table, Column[] columns, Criteria criteria)
//    @Override public String generate()
//}
//
//public class SelectWithMatchSql extends Sql {
//    public SelectWithMatchSql(String table, Column[] columns, Column column, String pattern)
//    @Override public String generate()
//}
//
//public class FindByKeySql extends Sql public FindByKeySql(
//        String table, Column[] columns, String keyColumn, String keyValue)
//        @Override public String generate()
//}
//
//public class PreparedInsertSql extends Sql {
//    public PreparedInsertSql(String table, Column[] columns)
//
//    @Override
//    public String generate() {
//        private String placeholderList (Column[]columns)
//    }
//
//    public class Where {
//        public Where(String criteria)
//
//        public String generate()
//    }
//
//    public class ColumnList {
//        public ColumnList(Column[] columns)
//
//        public String generate()
//    }
//}


// 새로운 SQL문을 지원할 때 해당 코드를 손대야 하고, 기존 SQL문을 수정할 때도 손대야 하므로 SRP위반한다.
// 예를 들어 select 문에 내장 된 select 문을 지원하려면 Sql 클래스를 고쳐야 한다.
// 이렇듯 변경 할 이유가 두 가지 이므로 Sql 클래스는 SRP 를 위반한다.
//class Sql {
//    public Sql(String table, Column[] columns)
//    public String create()
//    public String insert(Object[] fields)
//    public String selectAll()
//    public String findByKey(String keyColumn, String keyValue)
//    public String select(Column column, String pattern)
//    public String select(Criteria criteria)
//    public String preparedInsert()
//    private String columnList(Column[] columns)
//    private String valuesList(Object[] fields, final Column[] columns) private String selectWithCriteria(String criteria)
//    private String placeholderList(Column[] columns)
//}
