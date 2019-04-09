import java.util.*;

// fb
// merge email accounts
// not difficult, but hard to write, easy bugs
class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            int dedupIndex = -1;
            for (int j = 1; j < account.size(); j++) {
                if (emailToIndex.containsKey(account.get(j))) {
                    dedupIndex = emailToIndex.get(account.get(j));
                    break;
                }
            }
            int accountIndex = dedupIndex == -1 ? i : dedupIndex;
            Queue<String> emailsToDedupe = new LinkedList<>();
            emailsToDedupe.addAll(account.subList(1, account.size()));
            while (!emailsToDedupe.isEmpty()) {
                String emailToDedupe = emailsToDedupe.poll();
                if (!emailToIndex.containsKey(emailToDedupe)) {
                    emailToIndex.put(emailToDedupe, accountIndex);
                } else if (emailToIndex.get(emailToDedupe) != accountIndex) {
                    emailsToDedupe.addAll(accounts.get(emailToIndex.get(emailToDedupe)).subList(1, accounts.get(emailToIndex.get(emailToDedupe)).size()));
                    emailToIndex.put(emailToDedupe, accountIndex);
                }
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> pair : emailToIndex.entrySet()) {
            List<String> emails = indexToEmails.getOrDefault(pair.getValue(), new ArrayList<>());
            emails.add(pair.getKey());
            indexToEmails.put(pair.getValue(), emails);
        }
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> merged : indexToEmails.entrySet()) {
            List<String> account = new ArrayList<>();
            account.add(accounts.get(merged.getKey()).get(0));
            List<String> emails = merged.getValue();
            Collections.sort(emails);
            account.addAll(emails);
            mergedAccounts.add(account);
        }
        return mergedAccounts;
    }
}