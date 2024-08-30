package kh.com.acledabank;

import kh.com.acledabank.bakong.Database;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		String url = "jdbc:postgresql://10.11.20.56:5432/bk_osb_db";
        String user = "bk_osb_db";
        String password = "P$erbackdb$123";
        
//        System.out.println(Database.insertTrx(url, user, password, "abc003", "2024-02-12 11:55:00", "2024-02-12 11:56:00"));
//        System.out.println(Database.deleteTrx(url, user, password, "abc001"));
//        System.out.println(Database.updateTrx(url, user, password, "abc123", "abc003"));
        System.out.println(Database.selectTrx(url, user, password));
	}

}
