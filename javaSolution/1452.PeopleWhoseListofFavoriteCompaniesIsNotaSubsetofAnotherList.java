import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PeopleWhoseListofFavoriteCompaniesIsNotaSubsetofAnotherList {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> fc = new ArrayList<>();
        for (List<String> cs: favoriteCompanies) {
            fc.add(new HashSet<>(cs));
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < fc.size(); i++) {
            boolean isSubsets = false;
            for (int j = 0; j < fc.size(); j++) {
                if (j == i) continue;
                if (fc.get(j).containsAll(fc.get(i))) {
                    isSubsets = true;
                    break;
                }
            }
            if (!isSubsets) res.add(i);
        }
        return res;
    }
}