using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace carFactory
{
    class Toyota : car
    {
        private string company_t;
        private string model_t;
        private int speed_t;

        public Toyota(string model, int speed)
        {
            company_t = "Toyota";
            model_t = model;
            speed_t = speed;
        }

        public string Company
        {
            get
            {
                return company_t;
            }
        }

        public string Model
        {
            get { return model_t; }
            set { model_t = value; }
        }

        public int Speed
        {
            get { return speed_t; }
            set { speed_t = value; }
        }
    }
}
