namespace HelloWorld
{
    class Program
    {
        static async Task Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            Task<int> task = sleepFunction();
            Console.WriteLine("Hello World!2");

            int value = await task;
            Console.WriteLine("Hello World!3");
            Console.WriteLine("{0}", value);
        }

        private static async Task<int> sleepFunction() 
        {
            await Task.Delay(100);
            Console.WriteLine("sleepFunction");
            return 1;
        }
    }
}