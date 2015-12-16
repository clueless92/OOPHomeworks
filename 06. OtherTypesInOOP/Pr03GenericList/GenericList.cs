using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr04GenericListVersion;

namespace Pr03GenericList
{
    [Version(0, 5)]
    internal class GenericList<T> : IEnumerable<T> where T : IComparable
    {
        private const int DefaultSize = 4; // 4 is the default size in original List

        private T[] array;
        private int index;

        public GenericList(int size = DefaultSize)
        {
            this.array = new T[size];
            this.index = 0;
        }

        public int Count
        {
            get { return this.index; }
        }

        public void Add(T element)
        {
            this.ResizeIfFull();
            this.array[index] = element;
            index++;
        }

        private void ResizeIfFull()
        {
            if (this.index >= this.array.Length)
            {
                T[] resizedArray = new T[this.array.Length << 1];
                for (int i = 0; i < this.array.Length; i++)
                {
                    resizedArray[i] = this.array[i];
                }
                this.array = resizedArray;
            }
        }

        public T this[int index]
        {
            get
            {
                if (index < 0 || index >= this.index)
                {
                    throw new IndexOutOfRangeException(String.Format("Invalid index: {0}.", index));
                }

                T result = this.array[index];

                return result;
            }
        }

        public void RemoveAt(int index)
        {
            if (index < 0 || index >= this.index)
            {
                throw new IndexOutOfRangeException(String.Format("Invalid index: {0}.", index));
            }
            int size = this.Count - 1;
            for (int i = index; i < size; i++)
            {
                array[i] = array[i + 1];
            }
            this.index--;
        }

        public void Insert(int index, T element)
        {
            if (index < 0 || index > this.index)
            {
                throw new IndexOutOfRangeException(String.Format("Invalid index: {0}.", index));
            }
            this.ResizeIfFull();
            for (int i = this.index; i > index; i--)
            {
                this.array[i] = this.array[i - 1];
            }
            this.array[index] = element;
            this.index++;
        }

        public void Clear()
        {
            if (index > 0)
            {
                Array.Clear(array, 0, this.index); // no actual need to clear but it is done so in the original
                this.index = 0;
            }
        }

        public int IndexOf(T element)
        {
            for (int i = 0; i < this.Count; i++)
            {
                if (this.array[i].CompareTo(element) == 0)
                {
                    return i;
                }
            }
            return -1;
        }

        public int LastIndexOf(T element)
        {
            for (int i = this.Count - 1; i >= 0; i--)
            {
                if (this.array[i].CompareTo(element) == 0)
                {
                    return i;
                }
            }
            return -1;
        }

        public bool Contains(T element)
        {
            for (int i = 0; i < this.Count; i++)
            {
                if (this.array[i].CompareTo(element) == 0)
                {
                    return true;
                }
            }
            return false;
        }

        public override string ToString()
        {
            if (Count == 0)
            {
                return "[]";
            }
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < this.Count - 1; i++)
            {
                sb.AppendFormat("{0}, ", this.array[i]);
            }
            sb.AppendFormat("{0}]", this.array[this.Count - 1]);
            return sb.ToString();
        }

        public T Min()
        {
            T min = this.array[0];
            for (int i = 1; i < this.Count; i++)
            {
                if (min.CompareTo(this.array[i]) > 0)
                {
                    min = this.array[i];
                }
            }
            return min;
        }

        public T Max()
        {
            T max = this.array[0];
            for (int i = 1; i < this.Count; i++)
            {
                if (max.CompareTo(this.array[i]) < 0)
                {
                    max = this.array[i];
                }
            }
            return max;
        }

        public IEnumerator<T> GetEnumerator()
        {
            for (int i = 0; i < this.Count; i++)
            {
                yield return this.array[i];
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
    }
}
