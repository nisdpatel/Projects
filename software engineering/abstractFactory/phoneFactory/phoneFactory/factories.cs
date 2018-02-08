
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace phoneFactory
{
    class HTCFactory : IPhoneFactory
    {
        public iSmart getSmart()
        {
            return new Titan();
        }

        public iDumb getDumb()
        {
            return new Genie();

        }
    }

    class SamsungFactory : IPhoneFactory
    {
        public iSmart getSmart()
        {
            return new galaxyS2();
        }

        public iDumb getDumb()
        {
            return new Genie();

        }
    }

    class NokiaFactory : IPhoneFactory
    {
        public iSmart getSmart()
        {
            return new Lumia();
        }

        public iDumb getDumb()
        {
            return new Asha();

        }
    }

}
