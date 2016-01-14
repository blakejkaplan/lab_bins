bcw22, ert18, bjk20

Readability

What pieces of code help versus obscure your understanding of the algorithm?
It obscures my understanding when almost all of the code is in the main method.
It helps my understanding to have variable names which are descriptive of the data they stand for (for example, total and size when it comes to the files)

What comments might be helpful within the code?
It is helpful to explain what each method does, what the parameters in each method represent, and what the method is returning.

Are there places where the code could be more concise and also more clear?
Yes. The main method has four sections where the code is almost identical to one another and those areas could easily be clarified into one method.

Testability

How would you test this code for bugs?
If I had pre-written unit tests I would just run those unit tests. If not, I would either use a debugger or print statements on small data sizes so that I could check the validity of the algorithm by hand.

Give a specific example of a "test case" as the code is currently written.
We ran the original (before refactoring) version of the code on the example.txt file. The output was then compared to the output of the refactored code.

What additional functions may be helpful?
A function which prints out the contents of the priority queue after the files are added to the disk
A function which writes files to the disk

Give a specific example of a "test case" for your new function.
For the function which prints out the contents, run the program with the new function and before it was edited. Run a text diff on the two outputs to see if they’re any different.

Extensibility

What Code Smells can you find?
The lines of code which printed the outputs were almost identical between the first and second runs
The main method was very long and contained almost all of the logic for the entire program.

What suggestions does this code make about how someone would extend it in the future to compare the performance of a wider variety of fitting algorithms?
As it stands, the code doesn’t seem super extensible. Since almost everything is written in one method, it seems almost necessary to copy/paste similar code multiple times in that method in order to incorporate new fitting algorithms.
However, this code can be made more extensible by refactoring and encapsulating different parts of the program into different methods. This is what our group did in the code we submitted.

What dependencies are there between different parts of the code?
The priority queue and list of data are both required by almost every part of the program.

How easy to find are those dependencies?
It is sort of clear, but given the size of the main method it requires a fair bit of reading.

Can you clarify or remove those dependencies?
These dependencies can be clarified by defining them in a setup method and then passing those variables into submethods.

