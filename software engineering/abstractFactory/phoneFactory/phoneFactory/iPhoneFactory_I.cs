using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace phoneFactory
{
    
        interface IPhoneFactory
        {
         iSmart getSmart();
         iDumb getDumb();
        }
    }

