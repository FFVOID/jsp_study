package ch08;

import java.util.*;

public class RegistService {
	Map<String , Regist> regists = new HashMap<>();
	
	public RegistService() {
		
		Regist r1 = new Regist("101","김지우","서울시","silver","010-1111-1111");
		Regist r2 = new Regist("102","홍길동","인천시","gold","010-2222-2222");
		Regist r3 = new Regist("103","율곡","김포시","vip","010-3333-3333");
		
		regists.put("101", r1);
		regists.put("102", r2);
		regists.put("103", r3);
	}
	
	public ArrayList<Regist> findAll(){
		return new ArrayList<>(regists.values());
	}
	
	public Regist find(String id) {
		return regists.get(id);
	}
}
