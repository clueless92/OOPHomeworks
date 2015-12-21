namespace MyOOPExam20Dec2015.Interfaces
{
    using System.Collections.Generic;
    public interface IData
    {
        IDictionary<string, IBlob> Blobs { get; }
        void AddBlob(string blobName, IBlob blob);

        IBlob GetBlob(string blobName);
    }
}
