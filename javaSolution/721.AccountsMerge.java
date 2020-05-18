import java.util.*;

// fb
// merge email accounts
// not difficult, but hard to write, easy bugs
class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToId = new HashMap<>();
        Map<Integer, String> idToName = new HashMap<>();
        Map<Integer, Set<String>> idToEmails = new HashMap<>();

        int autoIncrementId = 0;
        for (List<String> acc: accounts) {
            String name = acc.get(0);
            List<Integer> ids = getAccountIds(acc, emailToId);
            int id = autoIncrementId;
            if (ids.size() > 0) {
                id = ids.get(0);
            } else {
                // new Account
                idToEmails.put(id, new HashSet<>());
                autoIncrementId++;
            }

            // link current account to `id`
            idToName.put(id, name);
            for (int i= 1; i < acc.size(); i++) {
                emailToId.put(acc.get(i), id);
                idToEmails.get(id).add(acc.get(i));
            }

            // link rest of connected account to `id`
            for (int i = 1; i < ids.size(); i++) {
                int idToConnect = ids.get(i);
                Set<String> emailToConnect = idToEmails.get(idToConnect);
                for (String email: emailToConnect) {
                    emailToId.put(email, id);
                    idToEmails.get(id).add(email);
                }
                idToEmails.remove(idToConnect);
            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int id: idToEmails.keySet()) {
            String name = idToName.get(id);
            List<String> emails = new ArrayList<>(idToEmails.get(id));
            Collections.sort(emails);
            emails.add(0, name);
            mergedAccounts.add(emails);
        }
        return mergedAccounts;
    }

    private List<Integer> getAccountIds(List<String> account, Map<String, Integer> emailToId) {
        Set<Integer> ids = new HashSet<>();
        for (int i = 1; i < account.size(); i++) {
            if (emailToId.containsKey(account.get(i))) {
                ids.add(emailToId.get(account.get(i)));
            }
        }
        return new ArrayList<>(ids);
    }
}