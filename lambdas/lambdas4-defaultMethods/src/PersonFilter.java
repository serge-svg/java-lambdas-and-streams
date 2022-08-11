public interface PersonFilter {

    boolean test(Person person);
    // Adding a OR clause on the active filter
    default PersonFilter or (PersonFilter personFilter) {
        return (p)->(test(p) || personFilter.test(p));
    }

}
