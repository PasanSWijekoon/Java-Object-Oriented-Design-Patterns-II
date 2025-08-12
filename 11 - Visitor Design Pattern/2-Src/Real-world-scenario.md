# Real-World Scenario:

Imagine an Insurance Company that insures different types of clients:

* Businesses (with annual revenue and employee count)
* Individuals (with personal details(name) and age)

They need to:

* Calculate insurance premiums differently for businesses and individuals.
* Generate customer reports differently for both.

**Challenge:**

If we put all operations (`calculatePremium()`, `generateReport()`) inside the classes, the classes become bloated. Also, adding new operations later will require modifying every class.