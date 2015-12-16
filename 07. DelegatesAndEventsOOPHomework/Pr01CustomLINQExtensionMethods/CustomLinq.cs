using System.Linq;

namespace Pr01CustomLINQExtensionMethods
{
    using System;
    using System.Collections.Generic;
    public static class CustomLinq
    {
        public static IEnumerable<T> WhereNot<T>(this IEnumerable<T> collection, Func<T, bool> func)
        {
            List<T> result = new List<T>();
            foreach (T item in collection)
            {
                if (!func(item))
                {
                    result.Add(item);
                }
            }
            return result;
        }

        public static TSelector Max<TSource, TSelector>(this IEnumerable<TSource> collection, Func<TSource, TSelector> func)
            where TSelector : IComparable
        {
            TSource max = collection.ToArray()[0];

            foreach (TSource item in collection)
            {
                if (func(item).CompareTo(func(max)) > 0)
                {
                    max = item;
                }
            }
            return func(max);
        }
    }
}
