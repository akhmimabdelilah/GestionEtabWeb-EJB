import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDao;
import entities.Employe;
import entities.Etudiant;
import entities.Filiere;
import entities.Role;
import entities.User;

public class TestEmploye {

	public static void main(String[] args) {
		
		try {
			//IDao<Employe> dao = lookup.EmployeRemote();
			IDao<Etudiant> daoE = lookup.EtudiantRemote();
			IDao<Role> daoR = lookup.RoleRemote();
			IDao<Filiere> daoF = lookup.FiliereRemote();
			
			daoF.create(new Filiere("Code","Name"));
			Filiere f1 = daoF.findById(1);
			Role r = new Role("R1");
			daoR.create(r);
			daoE.create(new Etudiant("ABCDE","login101","younes","HSSINE","0611758443",f1));
			daoF.create(new Filiere("Code","Name"));
			daoR.create(new Role("ROLE_Name"));
			Role role = daoR.findById(1);
			
			
			//dao.create(new Employe("TEST","TEST", 100000));
			//Employe emp= dao.findById(1);
			System.out.println("===========");
			//System.out.println(emp);
			System.out.println("===========");
			
			//dao.create(new Employe("EMP1","EMP1", 10000));
			//for(Employe elt : dao.findAll()) {
			//	System.out.println(elt);
			//}
			
			
			Etudiant E = daoE.findById(1);
			System.out.println(E);
			E.getRoles().add(role);
			daoE.update(E);
			for(Etudiant etd: daoE.findAll()) {
				 System.out.println(E);
			}
			Filiere f = daoF.findById(1);
			
			System.out.println(f);
			
			for(Etudiant etd: daoE.findByFiliere(f.getName())) {
				System.out.println(etd);
			}
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
