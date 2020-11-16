package setExam;

import java.util.TreeSet;

public class TreeSetExam {

	public static void main(String[] args) {
		
		/*
		한 요소에는 자기보다 작은 값의 주소를 가진 노드와 자기보다 큰 값의 주소를 가진 노드를 가지고 있다.
		데이터가 정렬된 위치에 저장이 되기 때문에 저장순서를 유지할 필요가 없다.
		한 요소나 범위를 검색할 때 링크드리스트보다 속닥 더 빠르다.
		정렬를 할 때도 이미 정렬된 위치에 저장이 되어있기 때문에 유리하다.
		중복된 데이터를 허용하지 않는다.
		
		요소 추가시 저장할 위치를 탐색을 해야하기 때문에 링크드리스트보다 속도가 느리다.
		삭제 또한 트리구조를 일부 변경해야하기 때문에 느리다.
		*/
		TreeSet<String> ts = new TreeSet<String>();
		
		String from = "b";
		String to = "d";
		
		ts.add("abc");
		ts.add("alien");
		ts.add("bat");
		ts.add("bazzi");
		ts.add("car");
		ts.add("Car");
		ts.add("disc");
		ts.add("dance");
		ts.add("dZZZZ");
		ts.add("elevator");
		ts.add("fan");
		ts.add("dzz");
		System.out.println(ts);
		// [Car, abc, alien, bat, car, dZZZZ, dance, disc, elevator, fan]
		// 트리셋은 자동으로 정렬해서 저장이된다.
		//b의 아스키코드값에서 c의 값까지 범위지정(b---- ~ c까지를 말한다)
		System.out.println(ts.subSet(from, to)); //b와 c로 시작되는 문자열만 검색
		// [bat, bazzi, car]
		System.out.println(ts.subSet(from, to+ "zz")); // dzz는 뒤에 zA문자열을 포함시켜야한다.
		//[bat, bazzi, car, dZZZZ, dance, disc]
		
		TreeSet<Integer> ts2 = new TreeSet<Integer>();
		int[] score = {80,90,50,35,35,65};
		
		for (int i = 0; i < score.length; i++) {
			ts2.add(score[i]);
		}
		
		System.out.println("50보다 큰 값" + ts2.tailSet(new Integer(50)));
		// 50보다 작은 값[50, 65, 80, 90]
		System.out.println("50보다 작은 값" + ts2.headSet(new Integer(50)));
		// 50보다 큰 값[35]
	}

}
