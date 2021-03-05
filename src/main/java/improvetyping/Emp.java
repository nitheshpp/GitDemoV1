package improvetyping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="emp_archode")
@Entity 
public class Emp {
String name;
@Id
int empno;
int deptid;

public Emp() {
	
	// TODO Auto-generated constructor stub
}
public Emp(String name,int empno , int deptid) {
	super();
	this.empno = empno;
	
	this.name = name;
	this.deptid = deptid;
}
public int getEmpno() {
	return empno;
}
public void setEmpno(int empno) {
	this.empno = empno;
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getDeptid() {
	return deptid;
}
public void setDeptid(int deptid) {
	this.deptid = deptid;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + empno;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	if (!(obj instanceof Emp)) {
		return false;
	}
	Emp other = (Emp) obj;
	if (empno != other.empno) {
		return false;
	}
	return true;
}



//@Override
//public int hashCode() {
//	return name.hashCode();
//}
//@Override
//public boolean equals(Object obj) {
//	if (this == obj)
//		return true;
//	if (obj == null)
//		return false;
//	if (!(obj instanceof Emp)) {
//		return false;
//	}
//	Emp other = (Emp) obj;
//
//	if (name == null) {
//		if (other.name != null)
//			return false;
//	} else if (!name.equals(other.name))
//		return false;
//	return true;
//}

}
