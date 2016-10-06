using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// The classes in this file are needed to make the CustomerRepository class compile.
namespace Samples.Chapter16.CopyAndPaste.Domain.Customer
{
    public enum Gender
    {
        Male,
        Female,
        Unknown
    }

    public class Customer
    {
        public Gender Gender { get; set; }

        public int? YearOfBirth { get; set; }
    }
}
