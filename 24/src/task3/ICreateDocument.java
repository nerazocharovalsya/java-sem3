package task3;

public interface ICreateDocument {
    public IDocument CreateNew(String stFolder, String stName, int iSize);

    public IDocument CreateOpen(String stName);
}
