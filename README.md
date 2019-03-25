# JPA - CRUD - Entity Service Lab

Requirements

* JDK 1.8
* SQL database


## Part 1: Create Data Model

1. Create a sql database using a RDBMS (MySql)
2. Create at least 2 tables to represent some relational object data
	* The tables should have 3-7 fields that represent the object
	* Tables must relate to one another. Examples:
		* One to Many
		* Many to Many
		* One to One
		* Many to One
3. Populate the database with records

__example__

a _cd_ table may have the fields for:

* id
* title
* desc
* year
* artist
* price

an _artist_ table may have the following:

* id
* first_name
* last_name
* instrument

An _artist-cd_ join table could then be used to create a _many to many_ relationship.

* cd_id
* artist_id

## Part 2: Add JPA specification and implementation dependencies

Use Maven.com to get the sql-connector-java dependency and jpa/hibernate dependencies. Add these to your pom.xml

## Part 3 Configure JPA

Create __persistence.xml__ file and save it to _src -> main -> resources -> META-INF_ folder

[More info](https://thoughts-on-java.org/jpa-persistence-xml/)

## Part 4: Create Services

Create services that are composed of an _EntityManager_ and has an interface for performing CRUD operations for managing _Entities_ with you database.

Service(s) should be able to perform at minimum the following:

* findById()
* findAll()
* update()
* create()
* delete()

Use annotations such as @ManyToMany or @OneToMany to create relations within your Entities.

```
@Entity
public class CD {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany()
    private Set<Musician> musicians = new HashSet<>();
```