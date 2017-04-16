package com.account.provider;

import org.apache.ibatis.jdbc.SQL;

import com.account.bean.User;
import static com.account.constants.TableConstants.*;

public class UserProvider {
	public String findAllUserByName(final User user) {
		return new SQL(){
			{
				SELECT("*");
				FROM(USER);
				StringBuffer where = new StringBuffer(" 1 = 1 ");
				if(user.getAccount()!=null && "".equals(user.getAccount().trim())){
					where.append(" and account like CONCAT ('%',#{user.account},'%') ");
				}
				if(user.getName()!=null && "".equals(user.getName().trim())){
					where.append(" and name like CONCAT ('%',#{user.name},'%') ");
				}
			}
		}.toString();
	}
}	
