import java.util.ArrayList;
import java.util.List;

interface StringChecker { boolean checkString(String s); }

class ListExamples {

  // Returns a new list that has all the elements of the input list for which
  // the StringChecker returns true, and not the elements that return false, in
  // the same order they appeared in the input list;
  static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(0, s);
      }
    }
    return result;
  }


  // Takes two sorted list of strings (so "a" appears before "b" and so on),
  // and return a new list that has all the strings in both list in sorted order.
  static List<String> merge(List<String> list1, List<String> list2) { //taking 2 lists of strings
    List<String> result = new ArrayList<>(); //init empty answer arraylist
    int index1 = 0, index2 = 0; //starting indices on both sorted lists = 0
    while(index1 < list1.size() && index2 < list2.size()) { //while curr index on both lists < size of both lists
      if(list1.get(index1).compareTo(list2.get(index2)) < 0) { //if curr list1 < curr list 2
        result.add(list1.get(index1)); //add curr list 1 to result
        index1 += 1; //inc index by 1
      }
      else { //if curr list1 >= curr list2
        result.add(list2.get(index2)); //add curr list 2 to result
        index2 += 1; //inc index by 1
      }
    }
    while(index1 < list1.size()) {
      result.add(list1.get(index1));
      index1 += 1;
    }
    while(index2 < list2.size()) {
      result.add(list2.get(index2));
      // change index1 below to index2 to fix test
      index1 += 1;
    }
    return result;
  }


}
