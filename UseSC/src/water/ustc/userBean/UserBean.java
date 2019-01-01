package water.ustc.userBean;

import water.ustc.userDao.UserDao;

public class UserBean {
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPass() {
        return userPass;
    }
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
    private String userName;
    private String userPass;
    public UserBean(){}
    //userPass是用户密码
    public UserBean(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }
    public boolean signIn(String username,String password){
        UserDao userDAO=UserDao.getInstance();
        UserBean userBean = (UserBean) userDAO.query(username);
        if (userBean==null){
            return false;
        }else{
            if(userBean.getUserPass().equals(password)){
                return true;
            }else {
                return false;
            }
        }
    }
}