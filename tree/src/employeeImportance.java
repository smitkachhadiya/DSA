import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class employeeImportance {

    //  690. Employee Importance

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> inputMap = new HashMap<>();
        for(Employee e : employees) {
            inputMap.put(e.id, e);
        }
        return helper(inputMap, id);
    }

    private static int helper(Map<Integer, Employee> inputMap, int id) {
        int imp = inputMap.get(id).importance;
        for(int subId : inputMap.get(id).subordinates) {
            imp += helper(inputMap, subId);
        }
        return imp;
    }

    //  Using Array

    private Employee[] emp;

    public int getImportance2(List<Employee> employees, int id) {
        emp = new Employee[2001];
        for (Employee e : employees)
            emp[e.id] = e;
        return dfs(emp[id]);
    }

    private int dfs(Employee e) {
        if (e == null) return 0;

        int ans = e.importance;
        for (int id : e.subordinates) {
            ans += dfs(emp[id]);
        }

        return ans;
    }

}
