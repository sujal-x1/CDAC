## ArrayList

- are iterable
    
- can contain similar datatypes unless using `Object`
    
- are ordered (maintain insertion order)
    
- allow duplicate elements
    
- allow `null` values
    
- support index-based access
    

## Sets

- are iterable
    
- do not allow duplicate elements
    
- ordering depends on implementation (`HashSet`, `LinkedHashSet`, `TreeSet`)
    
- can contain dissimilar datatypes when using `Object`
    
- allow `null` depending on implementation
    
- do not support index-based access
    

## HashMap

- stores data in key-value pairs
    
- allows different data types for keys and values, e.g. `HashMap<String, Integer>`
    
- keys must be unique, but values can be duplicated
    
- does not guarantee iteration order (`LinkedHashMap` maintains insertion order; `TreeMap` sorts keys)
    
- allows one `null` key and multiple `null` values in `HashMap`
    
- provides methods like `put()`, `get()`, `remove()`, `containsKey()` and `containsValue()`
    
- is not directly iterable; use `entrySet()`, `keySet()` or `values()` to iterate over its contents
    

## Generics

- allow you to specify the type of data a class, interface or method works with, e.g. `Class<T>`, `ArrayList<String>` or `ArrayList<Integer>`
    
- enable code reusability — write a class or method once and use it with different data types
    
- provide type safety by catching incompatible types at compile time
    
- use type parameters such as `<T>`, `<E>`, `<K, V>` to represent types
    
- use `<?>` as an unbounded wildcard when the specific generic type is unknown
    
- use `<? extends Number>` to accept a type of `Number` or its subclasses
    
- use `<? super Integer>` to accept a type of `Integer` or its supertypes
    
- remember that `<?>` does not mean converting an `Object` to a `String`; it means the generic type is unknown