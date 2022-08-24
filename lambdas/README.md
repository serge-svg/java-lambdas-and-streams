# Lambdas

Java lambda examples, these modules provide the necessary knowledge to the programmer to manage the principles of functional programming using lambda expressions and method references, with special emphasis on the use of static and default methods at the interface level.

* Lambda comes from the Lambda Calculus and refers to anonymous functions in programming.
* Lambda expressions can only be used to implement functional interfaces, which are interfaces having a single abstract method. An interface with two abstract methods can't be implemented by a lambda expression.
* A lambda expression allows you to write quick throw away functions without naming them. It also provides a nice way to write closures.
* Lambda expressions can access static variables, instance variables, effectively final method parameters, and effectively final local variables (just as Local Inner classes!).

Lambdas are composed by three parts:
1. Input parameters. The types may be present or omitted (if present for a parameter, then
   they must be present for other params a as well) . If the types are not present, and there is
   exactly 1 parameter (no 0 or more than 1) the parentheses may be omitted. Watch out for
   already defined variable names in the method where the lambda is defined--> won't
   compile (the parameter specification of a lambda expression does not create a new scope)
2. Arrow ->
3. body. If it has a single statement, braces{}, semicolon ; and return may be omitted (all
   omitted or none at all). If more than one statement, then braces{} are needed, semicolons for
   each statement and, if the method to implement has to return something, at least one return
   statement.

https://stackoverflow.com/questions/36233477/implementing-an-interface-with-two-abstract-methods-by-a-lambda-expression/36233545#36233545

