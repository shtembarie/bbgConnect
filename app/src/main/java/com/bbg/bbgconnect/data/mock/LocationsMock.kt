package com.bbg.bbgconnect.data.mock

import com.bbg.bbgconnect.data.models.Brochure
import com.bbg.bbgconnect.data.models.Coordinates
import com.bbg.bbgconnect.data.models.LocalizedText
import com.bbg.bbgconnect.data.models.Location
import com.bbg.bbgconnect.data.models.SocialMedia

/**
* Created by Enoklit on 19.05.2025.
*/
val locations = listOf(
    Location(
        id = "loc1",
        name = LocalizedText(
            de = "Hauptsitz",
            en = "Headquarters"
        ),
        address = "Hauptstraße 1",
        city = LocalizedText(
            de = "Berlin",
            en = "Berlin"
        ),
        country = LocalizedText(
            de = "Deutschland",
            en = "Germany"
        ),
        image = "https://images.unsplash.com/photo-1564501049412-61c2a3083791?q=80&w=2000&auto=format&fit=crop",
        history = LocalizedText(
            de = "Der Hauptsitz wurde 1995 gegründet und dient als zentraler Knotenpunkt für alle Unternehmensaktivitäten. Mit einer Fläche von über 5.000 Quadratmetern bietet er Platz für Innovation und Zusammenarbeit.",
            en = "The headquarters was established in 1995 and serves as the central hub for all company activities. With an area of over 5,000 square meters, it provides space for innovation and collaboration."
        ),
        employeeCount = 250,
        website = "https://www.company.com/headquarters",
        brochures = listOf(
            Brochure(
                id = "brochure1",
                title = LocalizedText(
                    de = "Unternehmensprofil 2023",
                    en = "Company Profile 2023"
                ),
                url = "https://www.example.com/company-profile.pdf"
            ),
            Brochure(
                id = "brochure2",
                title = LocalizedText(
                    de = "Standortbroschüre Berlin",
                    en = "Berlin Location Brochure"
                ),
                url = "https://www.example.com/berlin-brochure.pdf"
            )
        ),
        social = SocialMedia(
            linkedin = "https://www.linkedin.com/company/example",
            instagram = "https://www.instagram.com/example",
            twitter = "https://twitter.com/example"
        ),
        video = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
        coordinates = Coordinates(
            latitude = 52.520008,
            longitude = 13.404954
        )
    ),
    Location(
        id = "loc2",
        name = LocalizedText(
            de = "Forschungszentrum",
            en = "Research Center"
        ),
        address = "Innovationsweg 42",
        LocalizedText(
            de = "München",
            en = "Munich"
        ),
        country = LocalizedText(
            de = "Deutschland",
            en = "Germany"
        ),
        image = "https://images.unsplash.com/photo-1497366754035-f200968a6e72?q=80&w=2000&auto=format&fit=crop",
        history = LocalizedText(
            de = "Das Forschungszentrum wurde 2005 eröffnet und ist spezialisiert auf die Entwicklung neuer Technologien. Hier arbeiten über 100 Wissenschaftler an zukunftsweisenden Projekten.",
            en = "The Research Center was opened in 2005 and specializes in developing new technologies. More than 100 scientists work here on forward-looking projects."
        ),
        employeeCount = 120,
        website = "https://www.company.com/research",
        brochures = listOf(
            Brochure(
                id = "brochure3",
                title = LocalizedText(
                    de = "Forschungsschwerpunkte",
                    en = "Research Focus Areas"
                ),
                url = "https://www.example.com/research-focus.pdf"
            )
        ),
        social = SocialMedia(
            linkedin = "https://www.linkedin.com/company/example-research",
            twitter = "https://twitter.com/example_research"
        ),
        video = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
        coordinates = Coordinates(
            latitude = 48.137154,
            longitude = 11.576124
        )
    ),
    Location(
        id = "loc3",
        name = LocalizedText(
            de = "Produktionswerk",
            en = "Production Plant"
        ),
        address = "Industriestraße 15",
        city = LocalizedText(
            de = "Hamburg",
            en = "Hamburg"
        ),
        country = LocalizedText(
            de = "Deutschland",
            en = "Germany"
        ),
        image = "https://images.unsplash.com/photo-1556761175-5973dc0f32e7?q=80&w=2000&auto=format&fit=crop",
        history = LocalizedText(
            de = "Das Produktionswerk in Hamburg wurde 2010 in Betrieb genommen und ist mit modernster Technologie ausgestattet. Hier werden jährlich über 500.000 Einheiten produziert.",
            en = "The production plant in Hamburg was commissioned in 2010 and is equipped with state-of-the-art technology. More than 500,000 units are produced here annually."
        ),
        employeeCount = 180,
        website = "https://www.company.com/production",
        brochures = listOf(
            Brochure(
                id = "brochure4",
                title = LocalizedText(
                    de = "Produktionskapazitäten",
                    en = "Production Capacities"
                ),
                url = "https://www.example.com/production-capacity.pdf"
            )
        ),
        social = SocialMedia(
            linkedin = "https://www.linkedin.com/company/example-production",
            instagram = "https://www.instagram.com/example_production"
        ),
        coordinates = Coordinates(
            latitude = 53.551086,
            longitude = 9.993682
        )
    ),
    Location(
        id = "loc4",
        name = LocalizedText(
            de = "Vertriebsbüro",
            en = "Sales Office"
        ),
        address = "Marktplatz 8",
        city = LocalizedText(
            de = "Frankfurt",
            en = "Frankfurt"
        ),
        country = LocalizedText(
            de = "Deutschland",
            en = "Germany"
        ),
        image = "https://images.unsplash.com/photo-1497215842964-222b430dc094?q=80&w=2000&auto=format&fit=crop",
        history = LocalizedText(
            de = "Das Vertriebsbüro in Frankfurt wurde 2015 eröffnet und ist für den Vertrieb in Süddeutschland zuständig. Das Team besteht aus 50 Vertriebsexperten.",
            en = "The sales office in Frankfurt was opened in 2015 and is responsible for sales in southern Germany. The team consists of 50 sales experts."
        ),
        employeeCount = 50,
        website = "https://www.company.com/sales",
        brochures = listOf(
            Brochure(
                id = "brochure5",
                title = LocalizedText(
                    de = "Vertriebsregionen",
                    en = "Sales Regions"
                ),
                url = "https://www.example.com/sales-regions.pdf"
            )
        ),
        social = SocialMedia(
            linkedin = "https://www.linkedin.com/company/example-sales",
            twitter = "https://twitter.com/example_sales"
        ),
        video = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
        coordinates = Coordinates(
            latitude = 50.110924,
            longitude = 8.682127
        )
    ),
    Location(
        id = "loc5",
        name = LocalizedText(
            de = "Logistikzentrum",
            en = "Distribution Center"
        ),
        address = "Logistikweg 3",
        city = LocalizedText(
            de = "Köln",
            en = "Cologne "
        ),
        country = LocalizedText(
            de = "Deutschland",
            en = "Germany"
        ),
        image = "https://images.unsplash.com/photo-1604328698692-f76ea9498e76?q=80&w=2000&auto=format&fit=crop",
        history = LocalizedText(
            de = "Das Logistikzentrum in Köln wurde 2018 eröffnet und ist mit einem automatisierten Lagersystem ausgestattet. Von hier aus werden Produkte in ganz Europa verteilt.",
            en = "The logistics center in Cologne was opened in 2018 and is equipped with an automated storage system. Products are distributed throughout Europe from here."
        ),
        employeeCount = 75,
        website = "https://www.company.com/logistics",
        brochures = listOf(
            Brochure(
                id = "brochure6",
                title = LocalizedText(
                    de = "Logistikprozesse",
                    en = "Logistics Processes"
                ),
                url = "https://www.example.com/logistics-processes.pdf"
            )
        ),
        social = SocialMedia(
            linkedin = "https://www.linkedin.com/company/example-logistics"
        ),
        coordinates = Coordinates(
            latitude = 50.937531,
            longitude = 6.960279
        )
    )
)
