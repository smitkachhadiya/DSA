import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//  341. Flatten Nested List Iterator

public class flattenNestedListIterator {

    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();

        nestedList.add(new NestedIntegerImpl(Arrays.asList(
                new NestedIntegerImpl(1),
                new NestedIntegerImpl(1)
        )));

        nestedList.add(new NestedIntegerImpl(2));

        nestedList.add(new NestedIntegerImpl(Arrays.asList(
                new NestedIntegerImpl(1),
                new NestedIntegerImpl(1)
        )));

        NestedIterator iterator = new NestedIterator(nestedList);
        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        System.out.println(result);
    }
}

interface NestedInteger{
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    List<Integer> result = new ArrayList<>();

    public void flattenList(List<NestedInteger> list){
        for(NestedInteger num: list){
            if(num.isInteger()){
                result.add(num.getInteger());
            }else{
                flattenList(num.getList());
            }
        }
    };

    int idx;
    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList(nestedList);
        idx = 0;
    }

    @Override
    public Integer next() {
        Integer ans;
        ans = result.get(idx);
        idx++;

        return ans;
    }

    @Override
    public boolean hasNext() {
        if(idx < result.size()){
            return true;
        }

        return false;
    }
}

class NestedIntegerImpl implements NestedInteger {
    private Integer value;
    private List<NestedInteger> list;

    // Constructor for single integer
    public NestedIntegerImpl(int value) {
        this.value = value;
        this.list = new ArrayList<>();
    }

    // Constructor for nested list
    public NestedIntegerImpl(List<NestedInteger> list) {
        this.list = list;
        this.value = null;
    }

    @Override
    public boolean isInteger() {
        return value != null;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}