package ru.javawebinar.basejava.storage.serializer;

import ru.javawebinar.basejava.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());
            Map<ContactType, String> contacts = r.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }

            Map<SectionType, Section> sections = r.getSections();
            dos.writeInt(sections.size());
            for (Map.Entry<SectionType, Section> entry: sections.entrySet()){
                dos.writeUTF(entry.getKey().name());
                Section value = entry.getValue();
                dos.writeUTF(value.getClass().getName());
                if (value instanceof ListSection){
                    ListSection listSection = (ListSection) value;
                    dos.writeInt(listSection.getItems().size());
                    for (String str: listSection.getItems()){
                        dos.writeUTF(str);
                    }
                } else if (value instanceof TextSection) {
                    TextSection textSection = (TextSection) value;
                    dos.writeUTF(textSection.getContent());
                } else if (value instanceof OrganizationSection) {
                    OrganizationSection organizationSection = (OrganizationSection) value;
                    dos.writeInt(organizationSection.getOrganizations().size());
                    for (Organization organization: organizationSection.getOrganizations()){
                        Link homePage = organization.getHomePage();
                        dos.writeUTF(homePage.getName());
                        if (homePage.getUrl() != null){
                            dos.writeBoolean(true);
                            dos.writeUTF(homePage.getUrl());
                        } else {
                            dos.writeBoolean(false);
                        }

                        dos.writeInt(organization.getPositions().size());
                        for (Organization.Position position: organization.getPositions()){
                            dos.writeUTF(position.getStartDate().toString());
                            dos.writeUTF(position.getEndDate().toString());
                            dos.writeUTF(position.getTitle());
                            if (null != position.getDescription()){
                                dos.writeBoolean(true);
                                dos.writeUTF(position.getDescription());
                            } else {
                                dos.writeBoolean(false);
                            }
                        }

                    }
                }
            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }

            size = dis.readInt();
            for (int i = 0; i < size; i++) {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                Section section = null;
                String sectionClassName = dis.readUTF();
                if (sectionClassName.equals(ListSection.class.getName())){
                    int sizeList = dis.readInt();
                    List<String> list = new ArrayList<>();
                    for (int j = 0; j < sizeList; j++){
                        list.add(dis.readUTF());
                    }
                    if (list.size() > 0){
                        section = new ListSection(list);
                    }
                } else if (sectionClassName.equals(TextSection.class.getName())){
                    section = new TextSection(dis.readUTF());
                } else if (sectionClassName.equals(OrganizationSection.class.getName())){
                    List<Organization> organizations = new ArrayList<>();
                    int sizeOrg = dis.readInt();
                    for (int f = 0; f < sizeOrg; f++){
                        String homePage = dis.readUTF();
                        String url = null;
                        if (dis.readBoolean()){
                            url = dis.readUTF();
                        }

                        List<Organization.Position> positions = new ArrayList<>();
                        int sizePos = dis.readInt();
                        for (int k = 0; k < sizePos; k++){
                            LocalDate startDate = LocalDate.parse(dis.readUTF());
                            LocalDate endDate = LocalDate.parse(dis.readUTF());
                            String titel = dis.readUTF();
                            String discription = null;
                            if(dis.readBoolean()){
                                discription = dis.readUTF();
                            }
                            positions.add(new Organization.Position(startDate,endDate,titel,discription));
                        }
                        organizations.add(new Organization(new Link(homePage,url), positions));
                    }
                    section = new OrganizationSection(organizations);
                }
                resume.addSection(sectionType, section);
            }

            return resume;
        }
    }
}
