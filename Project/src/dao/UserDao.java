package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.Common;
import model.User;




/**
 * ユーザテーブル用のDao
 * @author takano
 *
 */
public class UserDao {


	/**
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     */
    public User findByLoginInfo(String loginId, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, Common.convert(password));
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new User(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }




//UserregisterServetに必要なDao 登録済みのログインIDを登録できないようにさせる
    public User findByloginId(String loginId) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            ResultSet rs = pStmt.executeQuery();

            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            return new User(loginIdData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }


//新規登録したモノをデータベースに登録するところ　setStringのところはまだ未完成(2018/03/28)→一応完了
    public void create(String loginId, String password, String name, String birthDate) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // INSERT文を用意して、それを配列として返してあげる。
            String sql = "INSERT INTO user(login_id,name,birth_date,password,create_date,update_date) VALUES (?,?,?,?,now(),now())";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, name);
            pStmt.setString(3, birthDate);
            pStmt.setString(4, Common.convert(password));

           pStmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }




    public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備る
            String sql = "SELECT * FROM user where login_id not in ('admin')";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }




            }
        }
        return userList;
    }

    public List<User> findSearch(String loginIdP,String nameP, String birthDateP,String birthDatePP) {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user where login_id not in ('admin')";

            if(!loginIdP.equals("")) {
            	sql += " and login_id = '" + loginIdP + "'";
            }

            if(!nameP.equals("")) {
            	sql += " and name LIKE '" + "%" + nameP + "%" + "'";
            }

            if(!birthDateP.equals("")) {
            	sql += " and birth_date >= '" + birthDateP + "'";
            }

            if(!birthDatePP.equals("")) {
            	sql += " and birth_date <= '" + birthDatePP + "'";
            }

            System.out.println(sql);


             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }




public User detailShow(String id1) {
    Connection conn = null;
    List<User> userList = new ArrayList<User>();

    try {
        // データベースへ接続
        conn = DBManager.getConnection();

        // SELECT文を準備
        String sql = "SELECT * FROM user WHERE id = ?";

        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.setString(1, id1);
        ResultSet rs = pStmt.executeQuery();



        while (rs.next()) {
            int id = rs.getInt("id");
            String loginId = rs.getString("login_id");
            String name = rs.getString("name");
            Date birthDate = rs.getDate("birth_date");
            String password = rs.getString("password");
            String createDate = rs.getString("create_date");
            String updateDate = rs.getString("update_date");
            User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);
            return user;
        }


    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    } finally {
        // データベース切断
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    return null;
}



//ユーザ情報更新のデータを持ってきて、それをデータに更新するDao

public void update(String loginId, String password, String name, String birthDate) {
    Connection conn = null;

    try {
        // データベースへ接続
        conn = DBManager.getConnection();

//passwordが、きちんと入力された場合
            if(password != "" ) {
            String sql = "UPDATE user SET password = ?, name = ? ,birth_date = ? WHERE login_id = ?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, Common.convert(password));
            pStmt.setString(2, name);
            pStmt.setString(3, birthDate);
            pStmt.setString(4, loginId);

           pStmt.executeUpdate();
        }
//passwordが入力されなかった場合
            else {
                String sql = "UPDATE user SET name = ? ,birth_date = ? WHERE login_id = ?";

                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, name);
                pStmt.setString(2, birthDate);
                pStmt.setString(3, loginId);

               pStmt.executeUpdate();
            }



    } catch (SQLException e) {
        e.printStackTrace();

    } finally {
        // データベース切断
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   }





public void deletedatabase(String id) {
    Connection conn = null;
    try {
        // データベースへ接続
        conn = DBManager.getConnection();

        // SELECT文を準備
        String sql = "DELETE FROM user  WHERE id = ?";

         // SELECTを実行し、結果表を取得
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.setString(1, id);
        pStmt.executeUpdate();


    } catch (SQLException e) {
        e.printStackTrace();

    } finally {
        // データベース切断
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
}


