package improvetyping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmpTestHibernate {

//	multi select
		public static void main1(String[] args) {
			
			Session q = HibernateUtil.getSessionFactory().openSession();
			//Entity classname, and not tablenam
			
			// from Classname and not tablename
			Query l = q.createQuery("from Emp  where deptid = :abc");
			l.setParameter("abc", 400043);
			List<Emp> users = l.list();
			for(Emp temp: users)
			{
				System.out.println(temp.getName());
			}
			
			
			
			
			
			
		}
//		select and update emp_archode
		public static void main2(String[] args) {
			
			//single select and update
			int empno=1;
			Session q = HibernateUtil.getSessionFactory().openSession();
											//Entity classname, and not tablename
			Emp user =q.get(Emp.class, empno); //scond arugment is primry key
			//we are getting a peristen object..
			
			if(user != null)
			{
			Transaction t = q.beginTransaction();
			user.setName("newpassword");
			user.setDeptid(8888);
			t.commit();  //make it permanenet
			}
			else
				System.out.println("user not found");
				
			q.close();
			System.out.println("working");

			
			
		}
//		insert
		public static void main(String[] args) {
			
		Session q = HibernateUtil.getSessionFactory().openSession();
		Emp user =new Emp("dhax",8,8888);
		
		
		
		Transaction t = q.beginTransaction();
		q.save(user);//now user becomes persistent..
		
		
		
		
		t.commit();  //make it permanenet
		q.close();
		System.out.println("working");
		
		}

//		delete
		public static void main3(String[] args) {
			Session q = HibernateUtil.getSessionFactory().openSession();
			Transaction t = q.beginTransaction();
			
			try {
				Query query=q.createQuery("delete from Emp where empno=:abc");
				
				query.setParameter("abc",8);
				query.executeUpdate();
				t.commit();
			} catch (Throwable tb) {
				// TODO Auto-generated catch block
				t.rollback();
				throw tb;
			}
			

		}
}
