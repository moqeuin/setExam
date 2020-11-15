package setExam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HashSetEaxam {

	public static void main(String[] args) {
		
		// set인터페이스를 구현한 클래스 중에 대표적인 클래스이다.
		// value값의 중복을 허용하지 않고 중복요소를 추가하면 false를 반환해서 추가에 실패
		// 저장순서를 보장하지않고 일정시간이 지나면 바뀐다
		Set<Object> hashSet = new HashSet<Object>();
		
		Object[] objArr = {"1",1,new Integer(1), "2","2","3","3","4","4","4"};
		
		for (int i = 0; i < objArr.length; i++) {
			hashSet.add(objArr[i]);
		}
		
		Iterator<Object> it = hashSet.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " "); //1 1 2 3 4
			// 문자열 1과 정수형 1은 자료형이 다르기 때문에 저장이 되었고 리터럴과 인스턴스는 같은 요소 취급한다.
		}
		System.out.println();
		
		
		Set<String> hashSet2 = new HashSet<String>();
		hashSet2.add("kiwi");
		hashSet2.add("orange");
		hashSet2.add("banana");
		hashSet2.add("apple");
		
		Iterator<String> it2 = hashSet2.iterator();
		while(it2.hasNext()) {
			System.out.print(it2.next() + " ");
		}
		// orange banana apple kiwi 
		// orange banana apple kiwi, 시간이 지나면 저장순서가 다시 바뀐다
		
		System.out.println();
		
		List<String> list = new LinkedList<String>(hashSet2);
		Collections.sort(list);
		
		it2 = list.iterator();
		while(it2.hasNext()) {
			System.out.print(it2.next() + " ");
		}
		//apple banana kiwi orange 
		//apple banana kiwi orange list로 저장 후  collections클래스로 정렬할 수 있다.
		
		System.out.println();
		
		hashSet.add(new Person("홍길동", 20));
		hashSet.add(new Person("홍길동", 20));
		// add메서드는 새로운 요소를 추가하기 전에 equals()와 hashCode()를 호출해서 같은지 확인한다.
		// Object클래스의 equals()에서 같은 값인지 확인하고 hashCode()해쉬코드가 같은 지 확인한다.
		// equals에서는 같지만 해쉬값이 다르기 때문에 객체가 다르다고 인식하고 set에서 중복해서 값이 들어간다.
		// 그래서 기존에 equals()와 hashCode()를 오버라이딩해야한다.
		
		
		it = hashSet.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");  	
		}
		// 1 1 2 3 4 홍길동:20
	}
		
}

class Person{
	
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	// obejct의 toString을 오버라이딩을 하면 객체변수만으로도 toString을 호출할 수 있다.
	public String toString(){
		return name + ":" + age;
	}
	
	// 객체의 내용 비교
	public boolean equals(Object obj) {
		// 참조주소 비교
		if(this == obj) return true;
		// 객체타입 비교
		if(!(obj instanceof Person)) { return false;}
		// 객체의 멤버변수의 값들을 비교
		Person p = (Person)obj;
		return this.name.equals(p.name) && this.age==p.age;
	}
	
	public int hashCode() {
		// 매개변수로 해쉬값을 생성
		return Objects.hash(this.name, this.age);
	}
}