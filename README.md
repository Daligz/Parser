# Parser
Lexical, syntactic and semantic analyzer written in java <br/>
![parse](docs/parse.png)

# About
Parser is a lexical, syntactic and semantic analyzer based on a specific lexical expression in order to create sets of flexible grammars.

# Semantic example
Examples will be shown showing the process that is carried out in two cases, one correct and one incorrect.

### Successful
12+5-0.5=1+2-1.5/25.21<br/>
![Successful1](docs/successful/Successful1.png)<br/>
![Successful2](docs/successful/Successful2.png)<br/>
![Successful3](docs/successful/Successful3.png)<br/>
![Successful4](docs/successful/Successful4.png)<br/>

### Unsuccessful
a+b-1=2+1-a/g<br/>
![unsuccessful1](docs/unsuccessful/unsuccessful1.png)<br/>
![unsuccessful2](docs/unsuccessful/unsuccessful2.png)<br/>
![unsuccessful3](docs/unsuccessful/unsuccessful3.png)<br/>
![unsuccessful4](docs/unsuccessful/unsuccessful4.png)<br/>

# Grammar
E -> A=B<br/>
A -> C-D<br/>
B -> B/D<br/>
B -> C-D<br/>
C -> D+D<br/>
D -> num|id<br/>
<br/>
P(E) = {num, id}<br/>
P(A) = {num, id}<br/>
P(B) = {num, id}<br/>
P(C) = {num, id}<br/>
P(D) = {num, id}<br/>
<br/>
S(E) = {$}<br/>
S(A) = {=}<br/>
S(B) = {=, /}<br/>
S(C) = {=}<br/>
S(D) = {$, =, -, /, num, id}<br/>
