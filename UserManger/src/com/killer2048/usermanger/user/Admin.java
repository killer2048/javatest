package com.killer2048.usermanger.user;

import java.sql.*;
import java.util.*;

import com.killer2048.usermanger.Main;
import com.killer2048.usermanger.sql.WithPreparedStatement;
import com.killer2048.usermanger.util.Input;
import com.killer2048.usermanger.util.Tools;

public class Admin extends User implements UserI,AdminI{

	public Admin(int id, String name, String email, String pw, int rights) {
		super(id, name, email, pw, rights);
	}

	@Override
	public void showMenu() {
		Tools.horizontalLine();
		System.out.println("添加用户-----------------------1");
		System.out.println("删除用户-----------------------2");
		System.out.println("修改用户-----------------------3");
		System.out.println("查询用户-----------------------4");
		System.out.println("程序退出-----------------------5");
	}

	@Override
	public void getOperation() {
		
		while(true) {
			//二级循环，登陆成功
			showMenu();
			int input = Input.getInt();
			switch (input) {
			case 1:
				addUser();
				break;	
			case 2:
				delUser();
				break;
			case 3:
				changeUser();
				break;
			case 4:
				findUser();
				break;
			case 5:
				return;
			default:
				Input.wrongInput();
			}
		}
	}
	
	@Override
	public void addUser() {
		String name=null;
		String pw=null;
		String mail=null;
		while (true) {
			name = Input.getName();
			if (name != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		while (true) {
			pw = Input.getPw();
			if (pw != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		while (true) {
			mail = Input.getMail();
			if (mail != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		boolean success = false;
		try {
			success = createUser(name,mail,pw,1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false;
		}
		if(success) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
		
	}
	protected boolean createUser(String name,String mail,String pw,int rights) throws SQLException {
		
		if (Tools.checkNameUsed(name)) {
			System.out.println("用户名已被使用");
			return false;
		}

		int ret = getRegSql(name, mail, pw,rights);
		if (ret > 0) {
			return true;
		}
		return false;
	}
	
	protected int getRegSql(String name, String mail, String pw, int rights){
		int ret=0;
		
		WithPreparedStatement regPs=null;
		try {
			regPs = new WithPreparedStatement(Main.getInstance().getConn().prepareStatement("insert into users (id,name,email,password,rights) values (users_id_autoincrease.nextval,?,?,?,?)"));
			regPs.set(1, name);
			regPs.set(2, mail);
			regPs.set(3, pw);
			regPs.set(4, rights);
			ret = regPs.update();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(regPs !=null) {
				try {
					regPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return ret;
	}
	
	
	@Override
	public void delUser() {
		int id=0;
		while (true) {
			System.out.println("请输入要删除用户的id号码");
			id = Input.getId();
			if (id != 0) {
				break;
			}
			Input.inputCheckFalse();
		}
		if(this.id == id) {
			System.out.println("当前用户无法删除，请重新输入ID");
		}
		UserI user = getUserFromId(id);
		if(user !=null) {
			if(this.rights<user.getRights()) {
				//删除权限高于自己的
				notAllow();
				return;
			}
		} else {
			System.out.println("用户不存在");
			return;
		}
		
		int ret = delById(id);
		if(ret>0) {
			System.out.println("删除用户成功");
		} else {
			System.out.println("删除失败");
		}
		
	}
	
	protected int delById(int id) {
		WithPreparedStatement wps = null;
		int ret=0;
		
		try {
			wps = new WithPreparedStatement(Main.getInstance().getConn().prepareStatement("delete from users where id=?"));
			wps.set(1, id);
			ret=wps.update();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(wps != null) {
				try {
					wps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return ret;
	}
	
	

	
	
	@Override
	public void changeUser() {
		int id = 0;
		String name=null;
		String pw=null;
		String mail=null;
		int rights = 0;
		while (true) {
			System.out.println("请输入要修改用户的id号码");
			id = Input.getId();
			if (id != 0) {
				break;
			}
			Input.inputCheckFalse();
		}
		while (true) {
			name = Input.getName();
			if (name != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		while (true) {
			pw = Input.getPw();
			if (pw != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		while (true) {
			mail = Input.getMail();
			if (mail != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		
		
		//自己不能修改自己权限
		if(id == this.id) {
			//修改自己信息
			changeInfo(name, mail, pw, this.rights, this);
			return;
		}
		while(true) {
			rights = Input.getRights(this.rights);
			if(rights>0) {
				break;
			}
			Input.inputCheckFalse();
		}
		UserI user = getUserFromId(id);
		if(user ==null) {
			System.out.println("用户不存在");
			return;
			
			
		}
		user.changeInfo(name, mail, pw,rights, this);
	}
	@Override
	public void findUser() {
		//子菜单
		findOp();
	}
	public void showFindMenu() {
		Tools.horizontalLine();
		System.out.println("查询全部用户-----------------------1");
		System.out.println("根据ID查询用户---------------------2");
		System.out.println("根据姓名查询用户（可模糊查询） ------3");
		System.out.println("返回上一级-------------------------4");
	}
	public void findOp() {
		while(true) {
			//三级循环，查询子菜单
			showFindMenu();
			int input = Input.getInt();
			switch (input) {
			case 1:
				findAll();
				break;	
			case 2:
				findById();
				break;
			case 3:
				findByName();
				break;
			case 4:
				return;
			default:
				Input.wrongInput();
			}
		}
	}
	public void findAll() {
		List<UserI> users = getAllUser();
		printUsers(users);
		
	}
	public void findById() {
		int id=0;
		while (true) {
			System.out.println("请输入要查询的用户的id号码");
			id = Input.getId();
			if (id != 0) {
				break;
			}
			Input.inputCheckFalse();
		}
		UserI user = getUserFromId(id);
		if(user !=null) {
			user.showInfo();
		} else {
			System.out.println("未查到满足条件的用户");
		}
	}
	
	public void findByName() {
		String name=null;
		while (true) {
			name = Input.getName();
			if (name != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		List<UserI> users = getUserFromName(name);
		printUsers(users);
		
	}

	protected void printUsers(List<UserI> users) {
		Iterator<UserI> it = users.iterator();
		if(!it.hasNext()) {
			System.out.println("未查到满足条件的用户");
		}
		while(it.hasNext()) {
			Tools.horizontalLine();
			it.next().showInfo();;
		}
	}
	@Override
	public UserI getUserFromId(int id) {
		User ret = null;
		WithPreparedStatement wps = null;
		ResultSet rs = null;
		try {
			wps = new WithPreparedStatement(Main.getInstance().getConn().prepareStatement("select id,name,email,password,rights from users where id=?"));
			wps.set(1, id);
			rs = wps.query();
			if(rs.next()) {
				ret = new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("password"),rs.getInt("rights"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(wps!=null) {
				try {
					wps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
	
	
	
	public List<UserI> getUserFromName(String name) {
		List<UserI> ret = new ArrayList<>();
		WithPreparedStatement wps = null;
		ResultSet rs = null;
		try {
			wps = new WithPreparedStatement(Main.getInstance().getConn().prepareStatement("select id,name,email,password,rights from users where name like ? order by id"));
			wps.set(1, "%"+name+"%");
			rs = wps.query();
			while(rs.next()) {
				ret.add(new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("password"),rs.getInt("rights")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(wps!=null) {
				try {
					wps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
	
	public List<UserI> getAllUser(){
		List<UserI> ret = new ArrayList<>();
		Statement st = Main.getInstance().getStatement();
		ResultSet rs=null;
		try {
			rs = st.executeQuery("select id,name,email,password,rights from users order by id");
			while(rs.next()) {
				ret.add(new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("password"),rs.getInt("rights")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return ret;
	}

}
