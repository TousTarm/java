public class TestovaciData
{
    // zkušební seznam videí
    private static Video [] seznamVidei =
        {   new Video("Alexander Veliký","Oliver Stone",170),
            new Video("Takoví normální zabijáci","Oliver Stone",119),
            new Video("60 sekund","Dominic Sena",118)
        };
        
    private static int videoUkazatel=0;
    
    // zkušební seznam CD
    private static CD [] seznamCD =
        {   new CD("Tři čunící","Jaromír Nohavica",25, 54),
            new CD("Divné století","Jaromír Nohavica",16, 48),
            new CD("Nebe počká","Karel Plíhal",23, 56),
            new CD("Enya (The Celts)", "Enya", 15, 39  ),
            new CD("The Memory of Trees", "Enya",11, 43)
        };
        
    private static int cdUkazatel=0;

    public static Evidence getEvidence() {
        Evidence temp = new Evidence();
        for (CD cd : seznamCD){
            temp.addCD(cd);
        }
        for (Video video : seznamVidei){
            temp.addVideo(video);
        }
        return temp;
    }

    public static Video getVideo() {
        Video temp = seznamVidei[videoUkazatel];
        videoUkazatel++;
        if (videoUkazatel >= seznamVidei.length) {
            videoUkazatel=0;
        }
        return temp;
    }

    public static CD getCD() {
        CD temp = seznamCD[cdUkazatel];
        cdUkazatel++;
        if (cdUkazatel >= seznamCD.length) {
            cdUkazatel=0;
        }
        return temp;
    }

}
