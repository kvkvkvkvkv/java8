Understanding java 8 with functional interfaces, lambdas and stream

Applying functinaly interfaces and chaining for
- [x]  Predicate
    - [x]  Chaining
        - [x]  and()
        - [x]  negate()
        - [x]  or()
        - [x]  isEqual()
    - [x]  test()
    - [x]  Use cases
- [x]  Function
    - [x]  Chaining
        - [x]  andThen()
        - [x]  identity()
        - [x]  compose()
    - [x]  apply()
    - [x]  Use cases
- [x]  Supplier
    - [x]  Chaining
        - [x]  no chaining no default static methods
    - [x]  get()
    - [x]  Use cases
- [x]  Consumer
    - [x]  Chaining
        - [x]  andThen()
    - [x]  accept()
    - [x]  Use cases
    
    
- [x]  Bi Functional
    - [x]  Bi Predicate
        - [x]  Chaining
            - [x]  and()
            - [x]  negate()
            - [x]  or()
            - [x]  isEqual() - not present
        - [x]  test()
        - [x]  Use cases
    - [x]  Bi Function
        - [x]  Chaining
            - [x]  andThen()
            - [x]  identity()- not present
            - [x]  compose() - not present
        - [x]  apply()
        - [x]  Use cases
    - [x]  Bi Consumer
        - [x]  Chaining
            - [x]  andThen()
        - [x]  accept()
        - [x]  Use cases
        
        
        
        
        
  - [x]  Primitive Functional Interface
    - [x]  Primitive Function
        - [x]  IntFunction
            - [x]  apply()
        - [x]  LongFunction
            - [x]  apply()
        - [x]  DoubleFunction
            - [x]  apply()
        - [x]  ToIntFunction
            - [x]  applyAsInt
        - [x]  ToLongFunction
            - [x]  applyAsLong
        - [x]  ToDoubleFunction
            - [x]  applyAsDouble
        - [x]  IntToDoubleFunction
            - [x]  applyAsDouble
        - [x]  IntToLongFunction
            - [x]  applyAsLong
        - [x]  LongToDoubleFunction
            - [x]  applyAsDouble
        - [x]  LongToIntFunction
            - [x]  applyAsInt
        - [x]  DoubleToIntFunction
            - [x]  applyAsInt
        - [x]  DoubleToLongFunction
            - [x]  applyAsLong
    - [x]  Primitive Bi Function
        - [x]  ToIntBiFunction
            - [x]  applyAsInt
        - [x]  ToDoubleBiFunction
            - [x]  applyAsDouble
        - [x]  ToLongBiFunction
            - [x]  applyAsLong
    - [x]  Primitive Consumer
        - [x]  IntConsumer
            - [x]  apply
        - [x]  DoubleConsumer
            - [x]  apply
        - [x]  LongCOnsumer
            - [x]  accept
    - [x]  Primitive Bi Consumer
        - [x]  ObjIntConsumer
            - [x]  apply
        - [x]  ObjDoubleConsumer
            - [x]  apply
        - [x]  ObjLongConsumer
            - [x]  apply
    - [x]  Primitive Supplier
        - [x]  IntSupplier
            - [x]  getAsInt
        - [x]  DoubleSupplier
            - [x]  getAsDouble
        - [x]  LongSupplier
            - [x]  getAsLong
    - [x]  Unary Operator
        - [x]  apply
        - [x]  static identity
    - [x]  Primitive Unary Function
        - [x]  IntUnaryFunction
            - [x]  applyAsInt
            - [x]  andThen
            - [x]  compose
            - [x]  Identity
        - [x]  DoubleUnaryFunction
            - [x]  applyAsDouble
            - [x]  andThen
            - [x]  compose
            - [x]  Identity
        - [x]  LongUnaryFunction
            - [x]  applyAsLong
            - [x]  andThen
            - [x]  compose
            - [x]  Identity
    - [x]  Binary Operator
        - [x]  apply
        - [x]  minBy
        - [x]  maxBy
    - [x]  Primitive Unary Function
        - [x]  IntBinaryOperator
            - [x]  applyAsInt
        - [x]  DoubleUnaryOperator
            - [x]  applyAsDouble
        - [x]  LongUnaryOperator
            - [x]  applyAsLong
    - [x]  Primitive Predicates
        - [x]  IntPredicate
            - [x]  test
            - [x]  and
            - [x]  or
            - [x]  negate
            - [x]  no isequal
        - [x]  DoublePredicate
            - [x]  test
            - [x]  and
            - [x]  or
            - [x]  negate
            - [x]  no isequal
        - [x]  LongPredicate
            - [x]  test
            - [x]  and
            - [x]  or
            - [x]  negate
            - [x]  no isequal
            
            
- [x]  Method Reference
    - [x]  Static Methods
        - [x]  custom FI
        - [x]  custom FI with Param
        - [x]  inbuilt FI
        - [x]  Overloading
    - [x]  Instance Methods
        - [x]  custom FI
        - [x]  custom FI with Param
        - [x]  inbuilt FI
        - [x]  Overloading
    - [x]  Constructor
        - [x]  custom FI
        - [x]  custom FI with Param
        - [x]  inbuilt FI
        - [x]  Overloading
        
        
        
        
- [x]  Functional Interface Inheritance
    - [x]  Why 1 abstract method
    - [x]  why @functional Interface
    - [x]  Fi extends fi without overriding
    - [x]  fi extends fi new method - error
    - [x]  class implements fi
    - [x]  Fi extends fi overrides
    
    
    
    
- [x]  Anonymous inner class vs Lambda
    - [x]  Anonymous extends concrete class
    - [x]  Anonymous extends abstract class
    - [x]  Anonymous extends interface with multiple methods
    - [x]  Anonymous extends interface with single method = lambda
    - [x]  Data variable in lambda and anonymous
- [x]  Data Variables in Lambda
- [x]  Default Methods
    - [x]  Inheritance
        - [x]  ambiguity unrelated interface
        - [x]  related interface - ClassName.super.methodName()
- [x]  Static Methods
    - [x]  modifier changes allowed
    - [x]  non static methods allowed
    - [x]  can have same method in child class not overidden
    
    
    
    
- [x]  Optionals
    - [x]  of
    - [x]  ofNUllable
    - [x]  empty
    - [x]  orelse
    - [x]  orElseGet
    - [x]  orElseThrow
    - [x]  map
    - [x]  flat map
    - [x]  equals
    - [x]  hash code
    - [x]  ifPresent
    - [x]  isPresent
    - [x]  get()
