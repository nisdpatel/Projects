using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace carFactory
{
    class Suzuki : car
    {
        private string company_s;
        private string model_s;
        private int speed_s;

        public Suzuki(string model, int speed)
        {
            company_s = "Suzuki";
            model_s = model;
            speed_s = speed;
        }

        public string Company
        {
            get
            {
                return company_s;
            }
        }

        public string Model
        {
            get { return model_s; }
            set { model_s = value; }
        }

        public int Speed
        {
            get { return speed_s; }
            set { speed_s = value; }
        }

    }
}
