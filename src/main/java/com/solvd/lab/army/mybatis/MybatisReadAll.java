package com.solvd.lab.army.mybatis;

import com.solvd.lab.army.model.Soldier;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;


    public class MybatisReadAll {

        public static void main(String args[]) throws IOException, IOException {

            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();


            List<Soldier> soldiers = session.selectList("com.solvd.lab.army.mybatis.mappers.SoldierMapper.getAll");

            for(Soldier st : soldiers ){
                System.out.println(st.getId());
                System.out.println(st.getFirstName());
                System.out.println(st.getLastName());
                System.out.println(st.getEmail());
            }

            session.commit();
            session.close();
        }
    }

