import java.util.*;

public class Evidence
{
    private List <CD> cds;
    private List <Video> videos;

    public Evidence()
    {
        cds = new ArrayList <CD>();
        videos = new ArrayList <Video>();
    }

    public void addCD(CD cd)
    {
        cds.add(cd);
    }

    public void addVideo(Video video)
    {
        videos.add(video);
    }

    public void vypisSeznam() {
        List<Polozka> seznamPolozek = new ArrayList<>();
        for (CD cd : cds) {
            seznamPolozek.add(cd);
        }
        for (Video video : videos) {
            seznamPolozek.add(video);
        }

        Collections.sort(seznamPolozek, new Comparator<Polozka>() {
            @Override
            public int compare(Polozka p1, Polozka p2) {
                int typComparison = p1.getTyp().compareTo(p2.getTyp());
                if (typComparison == 0) {
                    return p1.getTitul().compareTo(p2.getTitul());
                }
                return typComparison;
            }
        });

        for (Polozka polozka : seznamPolozek) {
            if (polozka instanceof CD) {
                ((CD) polozka).print();
            }
            else if (polozka instanceof Video) {
                ((Video) polozka).print();
            }
            System.out.println();  // prázdný řádek mezi položkami
        }
    }

}
