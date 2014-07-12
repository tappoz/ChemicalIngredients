grammar ChemicalIngredientsGrammar;

@lexer::members {
    boolean ignore=true;
}

// ************
// parser rules
// ************

// the measure stuff (amount and unit of measure)
measure : (value unit?) | (rangeValue unit?) ;
unit : UNITS ;

// the amount stuff
digi : DIGI ;
numberAsWord : NUMBER_AS_WORD ;
number : digi | numberAsWord ;
numberWithDecimals : NUMBER_WITH_DECIMALS ;
simpleFraction : SIMPLE_FRACTION ;
complexFranction : COMPLEX_FRACTION ;
value : number | numberWithDecimals | simpleFraction | complexFranction ;
// ranges
lowerBoundValue : value;
upperBoundValue : value;
rangeValue : lowerBoundValue LINK_IN_RANGE upperBoundValue ;

// ***********
// lexer rules
// ***********

DIGI : [0-9]+;
SIMPLE_FRACTION : (DIGI '/' DIGI) ;                // e.g. "1/2"
NUMBER_WITH_DECIMALS :  (DIGI ('.' DIGI)?) ;       // e.g. "2.5"
COMPLEX_FRACTION : (DIGI (' ' SIMPLE_FRACTION)?) ; // e.g. "1 1/2" (which is 1.5)

NUMBER_AS_WORD : ('one' | 'two' | 'three' | 'four' | 'five' | 'six' | 'seven' | 'eight' | 'nine' | 'ten') ;

LINK_IN_RANGE : ('to' | 'or') ;

UNITS : ('ml' | 'grams' | 'g' | 'gram' | 'cup' | 'l' | 'litres' | 'liters' | 'teaspoon' | 'teaspoons' | 'tablespoon' | 'cans' | 'ounces' | 'ounce' | 'tablespoons' | 'lb' | 'parts' | 'lbs' | 'cup' | 'cups' ) ;

WHITESPACE :  [ \t\r\n]+ { if(ignore) skip(); } ;
PUNCTUATION : [.,:;?!];

