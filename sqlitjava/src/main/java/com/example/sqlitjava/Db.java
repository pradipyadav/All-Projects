package com.example.sqlitjava;

public interface Db {

    String DB_NAME="my_info_sqlite";
    int DB_VERSION=1;

    interface Tab_MyInfo{

        String TAB_NAME="my_info";
        String COL_NAME="my_name";
        String COL_CARD_NUM="card_num";
    }
}
