package com.enviro.assessment.grad001.bongagougota.config;

import com.enviro.assessment.grad001.bongagougota.model.Guideline;
import com.enviro.assessment.grad001.bongagougota.model.RecyclingTip;
import com.enviro.assessment.grad001.bongagougota.model.Waste;
import com.enviro.assessment.grad001.bongagougota.model.WasteCategory;
import com.enviro.assessment.grad001.bongagougota.repository.GuidelineRepository;
import com.enviro.assessment.grad001.bongagougota.repository.RecyclingTipsRepository;
import com.enviro.assessment.grad001.bongagougota.repository.WasteRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Slf4j
@Component
public class DemoDataGenerator {
    Random random = new Random();
    private RecyclingTipsRepository recyclingTipsRepository;
    private GuidelineRepository guidelineRepository;
    private WasteRepository wasteRepository;

    public static final String[] WASTE_TITLES = new String[]{"Recycling", "Composting", "Landfilling", "Anaerobic", "Digestion",
            "Waste Segregation", "Biological Treatment", "Mechanical","Waste Minimization", "Thermal Treatment", "Energy Recovery"};
    public static final String[] WASTE_DESCRIPTIONS = {
            "Converts organic waste into nutrient-rich soil amendment through controlled decomposition",
            "Breaks down biodegradable materials in an oxygen-free environment to produce biogas and fertilizer",
            "Processes recyclable materials to recover valuable resources and reduce landfill waste",
            "Converts waste into energy through high-temperature combustion in controlled facilities",
            "Separates waste at source into different categories for efficient recycling and disposal",
            "Minimizes waste generation through better planning and resource management practices",
            "Uses earthworms to convert organic waste into high-quality vermicompost",
            "Treats waste through physical and chemical processes to reduce volume and toxicity",
            "Uses plasma technology to convert waste into synthesis gas and other useful byproducts",
            "Employs mechanical systems to sort different types of waste materials",
            "Applies biological methods to clean up contaminated materials and environments",
            "Uses heat to decompose materials in the absence of oxygen for fuel production",
            "Transforms waste materials into solid, stable forms for safer disposal",
            "Recovers energy from waste materials to generate electricity or heat",
            "Manages product returns and waste materials through supply chain processes",
            "Implements strategies to reduce waste generation at the source",
            "Uses chemical processes to treat and stabilize hazardous waste materials",
            "Employs thermal methods to reduce waste volume and recover energy",
            "Processes materials to recover valuable resources for reuse or recycling",
            "Disposes of waste in engineered facilities with environmental controls"
    };

    public static final String[] RECYCLING_TITLES = new String[]{"Recycle Today","Waste Not","Green Future","Sustainable Steps",
            "Eco-Friendly Choices","Zero Waste Mission","Reduce Reuse","Planet Protection","Recycling Revolution","Eco Warriors"};

    public static final String[] RECYCLING_DESCRIPTIONS = new String[]{"Recycling helps conserve natural resources and reduces waste in landfills.",
          "By recycling materials, we can reduce the need for raw materials and energy.", "Join the movement to keep our planet clean by recycling and reusing.",
          "Recycling is an easy way to make a positive impact on the environment.", "Recycling old products into new items helps protect the planet for future generations.",
          "Turning waste into resources is one of the best ways to promote sustainability.", "Recycling reduces pollution and decreases the carbon footprint.", "Every piece of recyclable material collected makes a difference for the planet.",
          "Incorporating recycling into your daily routine helps the environment immensely.", "Recycling programs encourage a cleaner, greener, and more sustainable world."};

    public static final String[] GUIDELINE_TITLES = new String[]{"Separate Your Waste", "Use Proper Bins",
            "Compost Organic Materials", "Dispose of Hazardous Waste Safely", "Avoid Single-Use Plastics", "Reduce, Reuse, Recycle",
            "Minimize Packaging Waste", "Follow Local Disposal Guidelines", "Properly Label Your Trash", "Recycle Electronics Responsibly"
    };
    public static final String[] GUIDELINE_DESCRIPTIONS = new String[]{
            "Always separate recyclables, compostables, and non-recyclables to ensure proper disposal.", "Make sure to use designated bins for different types of waste to prevent contamination.",
            "Composting organic waste like food scraps helps reduce landfill waste and enriches soil.", "Handle hazardous materials such as batteries, chemicals, and electronics with care and dispose of them at designated facilities.",
            "Opt for reusable items and avoid single-use plastics to reduce your environmental impact.", "Remember to reduce waste, reuse what you can, and recycle as much as possible to minimize landfill waste.",
            "Choose products with minimal or recyclable packaging to cut down on waste production.", "Always check and follow local waste disposal regulations to ensure compliance with environmental standards.",
            "Label your trash bins correctly so everyone in your household or workplace knows where to dispose of items.",
            "E-waste, such as old phones and computers, should be recycled responsibly to recover valuable materials and prevent pollution."
    };

    public static final String[] CATEGORIES = Arrays.stream(WasteCategory.values()).map(Enum::name).toArray(String[]::new);

    @Autowired
    public DemoDataGenerator(RecyclingTipsRepository recyclingTipsRepository, GuidelineRepository guidelineRepository,
                             WasteRepository wasteRepository){
        this.recyclingTipsRepository = recyclingTipsRepository;
        this.guidelineRepository = guidelineRepository;
        this.wasteRepository = wasteRepository;
    }

    @PostConstruct
    public void loadData(){
        log.info("Loading waste objects demo data...");
        generateWasteObjects();

        log.info("Loading guidelines demo data...");
        generateGuideLines();

        log.info("Loading recycling tips demo data...");
        generateRecyclingTips();
    }

    public void generateWasteObjects(){
        ArrayList<Waste> wasteArrayList = new ArrayList<>();
        int maxObjects = random.nextInt(5, 20);
        for(int i = 0; i < maxObjects; i++){
            Waste waste = new Waste();
            waste.setWasteTitle(WASTE_TITLES[random.nextInt(WASTE_TITLES.length)]);
            waste.setWasteCategory(WasteCategory.valueOf(CATEGORIES[random.nextInt(CATEGORIES.length)]));
            waste.setWasteDescription(WASTE_DESCRIPTIONS[random.nextInt(WASTE_DESCRIPTIONS.length)]);
            wasteArrayList.add(waste);
        }
        wasteRepository.saveAll(wasteArrayList);
    }

    public void generateRecyclingTips(){
        ArrayList<RecyclingTip> recyclingTipArrayList = new ArrayList<>();
        int maxObjects = random.nextInt(5, 20);
        for(int i = 0; i < maxObjects; i++){
            RecyclingTip recyclingTip = new RecyclingTip();
            recyclingTip.setCategory(CATEGORIES[random.nextInt(CATEGORIES.length)]);
            recyclingTip.setTitle(RECYCLING_TITLES[random.nextInt(RECYCLING_TITLES.length)]);
            recyclingTip.setDescription(RECYCLING_DESCRIPTIONS[random.nextInt(RECYCLING_DESCRIPTIONS.length)]);
            recyclingTipArrayList.add(recyclingTip);
        }
        recyclingTipsRepository.saveAll(recyclingTipArrayList);
    }

    public void generateGuideLines(){
        ArrayList<Guideline> guideLinesArrayList = new ArrayList<>();
        int maxObjects = random.nextInt(5, 20);
        for(int i = 0; i < maxObjects; i++){
            Guideline guideLine = new Guideline();
            guideLine.setGuideLineTitle(GUIDELINE_TITLES[random.nextInt(GUIDELINE_TITLES.length)]);
            guideLine.setGuideLineDescription(GUIDELINE_DESCRIPTIONS[random.nextInt(GUIDELINE_DESCRIPTIONS.length)]);
            guideLine.setWasteCategory(WasteCategory.valueOf(CATEGORIES[random.nextInt(CATEGORIES.length)]));
            guideLinesArrayList.add(guideLine);
        }
        guidelineRepository.saveAll(guideLinesArrayList);
    }
}
