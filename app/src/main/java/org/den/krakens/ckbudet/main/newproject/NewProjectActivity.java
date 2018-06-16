package org.den.krakens.ckbudet.main.newproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.models.Category;
import org.den.krakens.ckbudet.main.models.Tag;
import org.den.krakens.ckbudet.main.projects.category.TagsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewProjectActivity extends AppCompatActivity implements NewProjectVP.View {

    NewProjectVP.Presenter presenter;

    @BindView(R.id.title_et)
    EditText titleEditText;
    @BindView(R.id.category_spinner)
    AppCompatSpinner categorySpinner;
    @BindView(R.id.budget_spinner)
    AppCompatSpinner budgetSpinner;
    @BindView(R.id.description_et)
    EditText descriptionEditText;
    @BindView(R.id.place_et)
    EditText placeEditText;
    @BindView(R.id.tag_et)
    EditText tagEditText;
    @BindView(R.id.tags_rv)
    RecyclerView tagsRecyclerView;

    TagsAdapter tagsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);

        ButterKnife.bind(this);
        setPresenter();
        initComponents();
        presenter.loadCategories();
        presenter.loadBudgetTypes();
    }

    private void setPresenter() {
        presenter = new NewProjectPresenter(this);
    }

    private void initComponents() {
        tagsAdapter = new TagsAdapter(new ArrayList<>());
        tagsRecyclerView.setAdapter(tagsAdapter);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this, FlexDirection.ROW);
        tagsRecyclerView.setLayoutManager(layoutManager);
    }

    @OnClick(R.id.add_project_button)
    public void onAddProjectClick() {
        presenter.addProject(titleEditText.getText().toString(),
                descriptionEditText.getText().toString(),
                placeEditText.getText().toString(),
                (Category) categorySpinner.getSelectedItem(),
                (String) budgetSpinner.getSelectedItem(),
                tagsAdapter.getTags(),
                null,
                null);
    }

    @OnClick(R.id.add_tag_button)
    public void onAddTagClick() {
        String tagString = tagEditText.getText().toString();
        tagsAdapter.addTag(new Tag(0, tagString));
        tagEditText.setText("");
    }

    @Override
    public void updateCategories(List<Category> categories) {
        categorySpinner.setAdapter(new ArrayAdapter<Category>(this, android.R.layout.simple_spinner_dropdown_item, categories) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView) view.findViewById(android.R.id.text1)).setText(categories.get(position).getName());
                return view;
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView) view.findViewById(android.R.id.text1)).setText(categories.get(position).getName());
                return view;
            }
        });
    }

    @Override
    public void updateBudgetType(List<String> budgetTypes) {
        budgetSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, budgetTypes));
    }

    @Override
    public void showCategoryError() {
        Toast.makeText(this, "Nie udało się dodać pobrać kategorii.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProjectCreated() {
        Toast.makeText(this, "Dodano projekt.", Toast.LENGTH_LONG).show();
        this.finish();
    }

    @Override
    public void onProjectError() {
        Toast.makeText(this, "Nie udało się dodać projektu.", Toast.LENGTH_LONG).show();
    }
}
