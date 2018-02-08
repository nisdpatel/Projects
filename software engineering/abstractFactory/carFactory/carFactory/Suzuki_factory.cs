using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace carFactory
{
    class Suzuki_factory : car_factory
    {
        private string model_s;
        private int speed_s;

        public Suzuki_factory(string model, int speed)
        {
            model_s = model;
            speed_s = speed;
        }

        public override car getCar()
        {
            return new Suzuki(model_s, speed_s);
        }
    }
}