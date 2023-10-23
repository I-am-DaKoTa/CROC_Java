package ArturKuznetsov.lab3.task5.director;

import ArturKuznetsov.lab3.task5.builders.FridgeBuilder;
import ArturKuznetsov.lab3.task5.builders.RobotVacuumCleanerBuilder;
import ArturKuznetsov.lab3.task5.builders.WashingMachineBuilder;
import ArturKuznetsov.lab3.task5.enums.*;

public class Director {
    public void constructHyundaiFridge(FridgeBuilder builder){
        builder.setPrice(78980);
        builder.setName("Холодильник Side by Side Hyundai CM4505FV");
        builder.setDescription("""
                Этот отдельностоящий холодильник является великолепным выбором для всех, кто ценит эффективность и удобство.
                Благодаря инверторному компрессору, данный холодильник обеспечивает стабильную работу и экономичное энергопотребление.
                С его помощью вы сможете сохранить свежесть продуктов и наслаждаться холодильным комфортом.""");
        builder.setColor(Colors.GRAY);
        builder.setCountry(Countries.SOUTH_KOREA);
        builder.setWarranty(1);
        builder.setWeight(87);
        builder.setFridgeVolumeLiters(297);
        builder.setFreezerVolumeLiters(153);
        builder.setFreezerLocation(FreezerLocation.BOTTOM);
        builder.setEnergyEfficiency(EnergyEfficiency.A);
        builder.setWidthInCentimeters(83.3);
        builder.setHeightInCentimeters(177.5);
        builder.setDepthInCentimeters(65.5);
    }

    public void constructRedmondRobotVacuumCleaner(RobotVacuumCleanerBuilder builder){
        builder.setPrice(15890);
        builder.setName("Робот-пылесос REDMOND (RV-R151)");
        builder.setDescription("""
                Робот-пылесос RV-R151 – универсальный современный прибор для автоматической сухой и влажной уборки напольных покрытий.
                Пылесос имеет турбощетку в дополнение к боковым щеткам, а также съемный контейнер для воды и специальную насадку из микрофибры.
                А функция планирования работы делает прибор эффективным помощником в домашних делах.""");
        builder.setColor(Colors.BLACK);
        builder.setCountry(Countries.RUSSIA);
        builder.setWarranty(1);
        builder.setWeight(2.7);
        builder.setCleaningType(CleaningType.DRY_AND_WET);
        builder.setDustBagCapacity(0.35);
        builder.setSuctionPower(18);
        builder.setHeightChangeSensor(true);
        builder.setDustbinIndicator(true);
        builder.setDisplay(true);
    }

    public void constructSamsungWashingMachine(WashingMachineBuilder builder){
        builder.setPrice(82210);
        builder.setName("Стиральная машина SAMSUNG WD80T634DBH");
        builder.setDescription("""
                Стиральная машина SAMSUNG WD80T634DBH работает практически бесшумно и не потребляет много электроэнергии.
                Она оснащена цифровым инверторным мотором, который гарантией высокую производительность при минимальных затратах ресурсов.""");
        builder.setColor(Colors.WHITE);
        builder.setCountry(Countries.SOUTH_KOREA);
        builder.setWarranty(1);
        builder.setWeight(72);
        builder.setLoadType(LoadType.FRONT);
        builder.setMaxLoadKilograms(8);
        builder.setHasDryer(true);
        builder.setMaxSpinSpeedRPM(1400);
        builder.setEnergyEfficiency(EnergyEfficiency.A);
        builder.setWidthInCentimeters(60);
        builder.setHeightInCentimeters(85);
        builder.setDepthInCentimeters(60);
    }
}
