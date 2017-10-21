/**
 * Created by Marta on 2017-06-03.
 */
/** Question 6 REFLECTION: At first, this question seemed relatively easy. I simply had to create a stack and return
lowest value. However, this became harder when I realized that that I needed to find the lowest value in constant
 time; I could not sort through the entire stack and compare all the values. I had an idea: I would simply compare
 all values that I pushed into the stack to the first value, and if one was smaller, I would hold it in another variable.
 I would then return the variable when I called the min method. However, this presented another problem. If I popped the
 stack and the popped value was the min value, I had no way of updating the min variable to contain the next smallest
 variable without running the function in O(n) time. To fix this, I decided to create two lists whenever I added in a
 new value: one list would push each value as it was added, the other would push the added value only if it was smaller
 than the previous one. If it was not, the previous value would be repeated. This would mean that the smallest value in
 the list was still the previous value. Seeing this solution work was very rewarding for me because it took a lot of
 time to think of a way to track the smallest number in the stack in constant time.*/

public class Question6 {
    public static void main(String[] args) {

        System.out.println("Instancing a new stack...");
        MinStack testCase = new MinStack();
        System.out.println("Adding 14 to stack...");
        testCase.push(14);
        System.out.println("Adding 17 to stack...");
        testCase.push(17);
        System.out.println("Adding 6 to stack...");
        testCase.push(6);
        System.out.println("Adding 3 to stack...");
        testCase.push(3);
        System.out.print("The stack is currently: " );
        testCase.print();
        System.out.print("The size of the stack is currently: " + testCase.size());
        System.out.println();
        System.out.println("The minimum value of the stack is: " + testCase.min());
        System.out.println("Popping value from stack...");
        testCase.pop();
        System.out.print("The stack is now: " );
        testCase.print();
        System.out.print("The size of the stack is now: " + testCase.size());
        System.out.println();
        System.out.println("The minimum value of the stack is now: " + testCase.min());
}}
