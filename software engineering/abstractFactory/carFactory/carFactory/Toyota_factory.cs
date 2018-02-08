using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace carFactory
{
    class Toyota_factory : car_factory
    {
        private string model_t;
        private int speed_t;

        public Toyota_factory(string model, int speed)
        {
            model_t = model;
            speed_t = speed;
        }

        public override car getCar()
        {
            return new Toyota(model_t, speed_t);
        }
    }
}
