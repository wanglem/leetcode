import java.util.HashSet;
import java.util.Set;

//Google
class UniqueEmailAddress {
    class Email {
        String local;
        String domain;
        public Email(String local, String domain) {
            this.local = local;
            this.domain = domain;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Email other = (Email) obj;
            if (!local.equals(other.local) || !domain.equals(other.domain))
                return false;
            return true;
        }
        @Override
        public int hashCode() {
            return local.hashCode() * domain.hashCode();
        }
    }
    public int numUniqueEmails(String[] emails) {
        Set<Email> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String[] domainSplitByPlus = parts[0].split("\\+");
            String domainRemoveDot = domainSplitByPlus[0].replace(".", "");
            uniqueEmails.add(new Email(domainRemoveDot, parts[1]));
        }
        return uniqueEmails.size();
    }
}