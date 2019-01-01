package water.ustc.userDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import water.ustc.userBean.UserBean;
public class UserDao extends sc.ustc.dao.BaseDao{
	private static UserDao userDao = new UserDao();
	private UserDao() {
		driver = "com.mysql.cj.jdbc.Driver";
		userPassword = "zhouhao1106";
		userName = "root";
		url = "jdbc:mysql://localhost:3306/student";

	    connection = openDBConnection();
	    //connection = closeDBConnection();
	}
	
	public static UserDao getInstance() {
		if (userDao==null){
            userDao=new UserDao();
        }
        return userDao;
	}
	
	@Override
	public Object query(String name) {
		String pass="";
        String passWord = "password";
        String sql = "select "+passWord+" from sc where username = "+"'"+name+"'";
        //System.out.println(sql);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                pass= resultSet.getString("password");
            }
            UserBean userBean = new UserBean();
            userBean.setUserPass(pass);
            return userBean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
	@Override
	public boolean delete(String arg0) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean insert(String arg0) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean update(String arg0) {
		// TODO 自动生成的方法存根
		return false;
	}

}
