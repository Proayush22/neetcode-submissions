class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Car> stack = new Stack<>();
        Car[] cars = new Car[position.length];
        double t = 0;

        for(int i = 0; i < position.length; i++){
            t = (double) (target - position[i]) / speed[i];
            cars[i] = new Car(position[i], speed[i], t);

        }
        Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));

        for(int i = cars.length - 1; i >= 0; i--){
            if(stack.empty() || stack.peek().time < cars[i].time){
                stack.push(cars[i]);
            }
        }
        return stack.size();
    }

    public class Car{
        int position;
        int speed;
        double time;

        public Car(int position, int speed, double time){
            this.position = position;
            this.speed = speed;
            this.time = time;  
        }

    }
}
